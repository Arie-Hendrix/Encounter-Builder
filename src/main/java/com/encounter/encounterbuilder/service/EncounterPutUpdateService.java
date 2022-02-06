package com.encounter.encounterbuilder.service;

import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;

public interface EncounterPutUpdateService {

  Encounter createEncounter(EncounterRequest buildRequest);
  Encounter updateEncounter(Encounter encounter, EncounterRequest buildRequest);

}
