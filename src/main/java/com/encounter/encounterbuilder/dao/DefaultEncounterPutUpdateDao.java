package com.encounter.encounterbuilder.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEncounterPutUpdateDao implements EncounterPutUpdateDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Encounter saveEncounter(List<Character> characters, List<Monster> monsters,
      String encounterName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String fetchEncounterName(String encounterName) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Monster> fetchMonsters(List<Monster> monsters) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Character> fetchCharacters(List<Character> characters) {
    // TODO Auto-generated method stub
    return null;
  }
  

}
