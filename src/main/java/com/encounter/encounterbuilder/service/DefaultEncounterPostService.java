package com.encounter.encounterbuilder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.EncounterPostDao;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;
import com.encounter.encounterbuilder.entity.Monster;
import com.encounter.encounterbuilder.entity.Character;

@Service
public class DefaultEncounterPostService implements EncounterPostService {

  @Autowired
  private EncounterPostDao encounterPutDao;

  @Override
  public Encounter createEncounter(EncounterRequest request) {
    
    List<Character> characters = getCharacters(request);
    List<Monster> monsters = getMonsters(request);
    String name = getEncounterName(request);
    // Encounter encounter = getEncounter(request);
    
    return encounterPutDao.saveEncounter(characters, monsters, name);
  }

  private String getEncounterName(EncounterRequest request) {
    //return encounterPutDao.
    return null;
  }

  private List<Monster> getMonsters(EncounterRequest request) {
   return encounterPutDao.fetchMonsters(request.getMonsters());
  }

  private List<Character> getCharacters(EncounterRequest request) {
    return encounterPutDao.fetchCharacters(request.getCharacters());
  }
}
