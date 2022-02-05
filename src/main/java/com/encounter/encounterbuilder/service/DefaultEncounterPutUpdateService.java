package com.encounter.encounterbuilder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.EncounterPutUpdateDao;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterBuildRequest;
import com.encounter.encounterbuilder.entity.Monster;

@Service
public class DefaultEncounterPutUpdateService implements EncounterPutUpdateService {

  @Autowired
  private EncounterPutUpdateDao encounterPutUpDao;
  
  @Transactional
  @Override
  public Encounter createEncounter(EncounterBuildRequest buildRequest) {
    List<Character> characters = getCharacters(buildRequest);
    List<Monster> monsters = getMonsters(buildRequest);
    String encounterName = getEncounterName(buildRequest);
    
    return encounterPutUpDao.saveEncounter(characters, monsters, encounterName);
  }

  private String getEncounterName(EncounterBuildRequest buildRequest) {
    
    return encounterPutUpDao.fetchEncounterName(buildRequest.getEncounterName());
  }

  private List<Monster> getMonsters(EncounterBuildRequest buildRequest) {
    
    return encounterPutUpDao.fetchMonsters(buildRequest.getMonsters());
  }

  private List<Character> getCharacters(EncounterBuildRequest buildRequest) {
    
    return encounterPutUpDao.fetchCharacters(buildRequest.getCharacters());
  }

  @Override
  public Encounter updateEncounter(Encounter encounter, EncounterBuildRequest buildRequest) {
    
    return null;
  }
}
