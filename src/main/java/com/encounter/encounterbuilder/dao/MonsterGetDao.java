package com.encounter.encounterbuilder.dao;

import java.util.List;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Monster;

public interface MonsterGetDao {

  List<Monster> getMonstersOfType(CreatureType type);

}
