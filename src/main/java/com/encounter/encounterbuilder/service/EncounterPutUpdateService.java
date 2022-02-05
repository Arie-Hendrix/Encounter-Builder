package com.encounter.encounterbuilder.service;

import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterBuildRequest;

public interface EncounterPutUpdateService {

  Encounter createEncounter(EncounterBuildRequest buildRequest);
  Encounter updateEncounter(Encounter encounter, EncounterBuildRequest buildRequest);

}
