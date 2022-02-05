package com.encounter.encounterbuilder.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.EncounterGetDao;
import com.encounter.encounterbuilder.entity.Encounter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEncounterGetService implements EncounterGetService{
  
  @Autowired
  private EncounterGetDao encounterGetDao;
  
//  @Override
//  public Encounter fetchEncounter(long encounterPk) {
//    
//    return null;
//  }

  @Transactional(readOnly = true)
  @Override
  public List<Encounter> fetchEncounter(String encounterName) {
    log.info("fetchEncounter called with encounterName = {}", encounterName);
    
    List<Encounter> encounter = encounterGetDao.displayEncounter(encounterName);
    if(encounter.isEmpty()) {
      String msg = String.format("No encounters found with the name:", encounterName);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(encounter);
    return encounter;
  }

  @Override
  public List<Encounter> fetchEncounters() {
      log.info("fetchEncounters called, displaying all encounters");
      
      List<Encounter> encounters = encounterGetDao.displayEncounters();
      if(encounters.isEmpty()) {
        String msg = String.format("No encounters found");
        throw new NoSuchElementException(msg);
      }
      
      Collections.sort(encounters);
      return encounters;
  }

}
