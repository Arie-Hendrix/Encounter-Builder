package com.encounter.encounterbuilder.service;

import com.encounter.encounterbuilder.entity.Encounter;

public interface EncounterUpdateService {
  
  Encounter updateEncounter (String name, String newName);

}
