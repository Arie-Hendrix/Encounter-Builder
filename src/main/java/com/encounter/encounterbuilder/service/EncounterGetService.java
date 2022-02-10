package com.encounter.encounterbuilder.service;

import java.util.List;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;

public interface EncounterGetService {
  
  Encounter fetchEncounter(String encounterName);
  // Encounter fetchEncounter(long encounterPK);
  // List<Encounter> fetchEncounters();
  List<Monster> fetchAllMonstersByType(CreatureType type);
  
}
