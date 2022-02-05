package com.encounter.encounterbuilder.dao;

import java.util.List;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;

public interface EncounterGetDao {

  List<Encounter> displayEncounter(long encounterPk);
  
  List<Encounter> displayEncounters();

  List<Encounter> displayEncounter(String encounterName);
  
  List<Monster> displayMonstersOfType(CreatureType type);

  List<Character> displayPlayerCharacters(String firstName, String lastName);
  
}
