package com.encounter.encounterbuilder.dao;

import java.util.List;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;

public interface EncounterGetDao {

  Encounter getEncounter(String encounterName);
  
  List<Monster> getEncounterMonsters(Long encounterId);

  List<Character> getEncounterCharacters(Long encounterId);
  
  List<Monster> getAllMonstersOfType(CreatureType type);
 
  // List<Character> getAllPlayerCharacters();
}
