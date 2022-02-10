package com.encounter.encounterbuilder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Monster;
import com.encounter.encounterbuilder.service.MonsterGetService;

@RestController
public class DefaultMonsterGetController implements MonsterGetController {

  @Autowired
  private MonsterGetService monsterService;
  
  @Override
  public List<Monster> fetchMonstersOfType(CreatureType type) {
     return monsterService.fetchMonstersOfType(type);

  }

}
