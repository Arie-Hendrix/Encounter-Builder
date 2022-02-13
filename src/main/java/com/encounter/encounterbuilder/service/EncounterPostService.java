package com.encounter.encounterbuilder.service;

import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;

public interface EncounterPostService {

  Encounter createEncounter(EncounterRequest request, String name);

}
