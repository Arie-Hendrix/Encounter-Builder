package com.encounter.encounterbuilder.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.service.EncounterUpdateService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEncounterUpdateController implements EncounterUpdateController {

  @Autowired
  private EncounterUpdateService updateService;
  
  @Override
  public Encounter updateEncounter(@Valid String name, @Valid String newName) {
    log.debug("Controller: updateEncouter called: {}", name);
    return updateService.updateEncounter(name, newName);
  }

}
