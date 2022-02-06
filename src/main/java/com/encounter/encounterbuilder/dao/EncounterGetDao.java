package com.encounter.encounterbuilder.dao;

import java.util.List;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;

public interface EncounterGetDao {

  List<Encounter> getEncounter(String encounterName);
  
  List<Monster> getMonsters(Long encounterId);

  List<Character> getPlayerCharacters(Long encounterId);
 
}
