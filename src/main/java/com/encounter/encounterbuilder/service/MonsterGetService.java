package com.encounter.encounterbuilder.service;

import java.util.List;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Monster;

public interface MonsterGetService {
  
  List<Monster> fetchMonstersOfType(CreatureType type);

}
