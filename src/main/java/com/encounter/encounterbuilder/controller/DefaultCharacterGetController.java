package com.encounter.encounterbuilder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.service.CharacterGetService;

@RestController
public class DefaultCharacterGetController implements CharacterGetController {

  @Autowired
  private CharacterGetService characterService;
  
  @Override
  public List<Character> fetchAllPlayerCharacters() {
    return characterService.fetchAllPlayerCharacters();
  }

}
