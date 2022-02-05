package com.encounter.encounterbuilder.service;

import java.util.List;
import com.encounter.encounterbuilder.entity.Encounter;

public interface EncounterGetService {
  
  List<Encounter> fetchEncounter(String encounterName);
  // Encounter fetchEncounter(long encounterPK);
  List<Encounter> fetchEncounters();

}
