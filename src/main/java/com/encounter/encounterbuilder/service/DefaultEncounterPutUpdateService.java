package com.encounter.encounterbuilder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.EncounterPutUpdateDao;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;
import com.encounter.encounterbuilder.entity.Monster;

@Service
public class DefaultEncounterPutUpdateService implements EncounterPutUpdateService {

  @Autowired
  private EncounterPutUpdateDao encounterPutUpDao;

  @Override
  public Encounter createEncounter(EncounterRequest buildRequest) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Encounter updateEncounter(Encounter encounter, EncounterRequest buildRequest) {
    // TODO Auto-generated method stub
    return null;
  }
  
//  @Transactional
//  @Override
//  public Encounter createEncounter(EncounterRequest buildRequest) {
//    List<Character> characters = getCharacters(buildRequest);
//    List<Monster> monsters = getMonsters(buildRequest);
//    String encounterName = getEncounterName(buildRequest);
//    
//    return encounterPutUpDao.saveEncounter(characters, monsters, encounterName);
//  }
//
//  private String getEncounterName(EncounterRequest buildRequest) {
//    
//    return encounterPutUpDao.fetchEncounterName(buildRequest.getEncounterName());
//  }
//
//  private List<Monster> getMonsters(EncounterRequest buildRequest) {
//    
//    return encounterPutUpDao.fetchMonsters(buildRequest.getMonsters());
//  }
//
//  private List<Character> getCharacters(EncounterRequest buildRequest) {
//    
//    return encounterPutUpDao.fetchCharacters(buildRequest.getCharacters());
//  }
//
//  @Override
//  public Encounter updateEncounter(Encounter encounter, EncounterRequest buildRequest) {
//    
//    return null;
  }
