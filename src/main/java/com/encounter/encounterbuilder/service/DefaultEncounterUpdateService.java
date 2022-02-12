package com.encounter.encounterbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.encounter.encounterbuilder.dao.EncounterUpdateDao;
import com.encounter.encounterbuilder.entity.Encounter;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultEncounterUpdateService implements EncounterUpdateService {
  
  @Autowired
  private EncounterUpdateDao updateDao;

  @Override
  public void updateEncounter(String name, String newName) {
    log.debug("Service: changing encounter from {} to {}", name, newName);
    updateDao.updateEncounter(name, newName);
  }

}
