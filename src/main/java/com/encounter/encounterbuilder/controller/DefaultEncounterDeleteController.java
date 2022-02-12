package com.encounter.encounterbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.encounter.encounterbuilder.service.EncounterDeleteService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEncounterDeleteController implements EncounterDeleteController {

  @Autowired
  private EncounterDeleteService deleteService;
  
  @Override
  public void removeEncounter(String name) {
    log.debug("Deleting encounter: " + name);
    deleteService.deleteEncounter(name);
  }

}
