package com.encounter.encounterbuilder.dao;

import com.encounter.encounterbuilder.entity.Encounter;

public interface EncounterUpdateDao {

  Encounter updateEncounter(String name, String newName);

}
