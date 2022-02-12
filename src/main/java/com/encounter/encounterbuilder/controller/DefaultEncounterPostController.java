package com.encounter.encounterbuilder.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.EncounterRequest;
import com.encounter.encounterbuilder.service.EncounterPostService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultEncounterPostController implements EncounterPostController {

  @Autowired
  private EncounterPostService postService;
  
  @Override
  public Encounter createEncounter(EncounterRequest request) {
    log.debug("createEncounter called");
   return postService.createEncounter(request);
  }

}
