package com.encounter.encounterbuilder.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.EncounterGetDao;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEncounterGetService implements EncounterGetService{
  
  @Autowired
  private EncounterGetDao encounterGetDao;

  @Transactional(readOnly = true)
  @Override
  public Encounter fetchEncounter(String encounterName) {
log.info("The fetchEncounter method was called with name={}", encounterName);
    
    Encounter encounter = encounterGetDao.getEncounter(encounterName);
    if(encounter == null) {
      String msg = String.format("No encounters found with name =%s", encounterName);
      throw new NoSuchElementException(msg);
    }
    return encounter;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Monster> fetchAllMonstersByType(CreatureType type) {
   log.info("Method called to fetch monsters by their type; type = {}", type);
   List<Monster> monsters = encounterGetDao.getAllMonstersOfType(type);
   
   if(monsters.isEmpty()) {
     String msg = String.format("No monsters of type %s were found", type);
     throw new NoSuchElementException(msg);
   }
    return monsters;
  }
}
