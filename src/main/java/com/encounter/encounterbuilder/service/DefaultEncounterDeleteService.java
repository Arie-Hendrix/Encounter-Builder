package com.encounter.encounterbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encounter.encounterbuilder.dao.EncounterDeleteDao;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEncounterDeleteService implements EncounterDeleteService {

  @Autowired
  private EncounterDeleteDao deleteDao;
  
  @Override
  public void deleteEncounter(String name) {
    log.info("Sevice later: deleteEcnounter called for: " + name);
    deleteDao.deleteEcnounter(name);    
  }
}
