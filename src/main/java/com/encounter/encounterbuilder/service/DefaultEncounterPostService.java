package com.encounter.encounterbuilder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.EncounterPostDao;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;
import com.encounter.encounterbuilder.entity.Monster;
import lombok.extern.slf4j.Slf4j;
import com.encounter.encounterbuilder.entity.Character;

@Service
@Slf4j
public class DefaultEncounterPostService implements EncounterPostService {

  @Autowired
  private EncounterPostDao encounterPostDao;

  @Override
  public Encounter createEncounter(EncounterRequest request, String name) {
    log.debug("SERVICE: createEncounter method called");
    List<Character> characters = getCharacters(request);
    List<Monster> monsters = getMonsters(request);
    // Encounter encounter = getEncounter(request);
    
    return encounterPostDao.saveEncounter(characters, monsters, name);
  }

  private List<Monster> getMonsters(EncounterRequest request) {
   return encounterPostDao.fetchMonsters(request.getMonsters());
  }

  private List<Character> getCharacters(EncounterRequest request) {
    return encounterPostDao.fetchCharacters(request.getCharacters());
  }
}
