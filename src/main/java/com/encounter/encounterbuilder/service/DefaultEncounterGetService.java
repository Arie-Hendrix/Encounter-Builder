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

  @Transactional(readOnly = true)
  @Override
  public List<Encounter> fetchEncounter(String encounterName) {
log.info("The fetchEncounter method was called with name={}", encounterName);
    
    List<Encounter> encounters = encounterGetDao.getEncounter(encounterName);
    if(encounters.isEmpty()) {
      String msg = String.format("No encounters found with name =%s", encounterName);
      throw new NoSuchElementException(msg);
    }
    
    Collections.sort(encounters);
    return encounters;
  }
}
