package com.encounter.encounterbuilder.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.MonsterGetDao;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Monster;

@Service
public class DefaultMonsterGetService implements MonsterGetService{
  
  @Autowired
  private MonsterGetDao monsterDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Monster> fetchMonstersOfType(CreatureType type) {
    List<Monster> monsters = monsterDao.getMonstersOfType(type);
    if(monsters.isEmpty()) {
      String msg = String.format("No monsters found of the type %s", type);
      throw new NoSuchElementException(msg);
    }
    
    return monsters;
  }

}
