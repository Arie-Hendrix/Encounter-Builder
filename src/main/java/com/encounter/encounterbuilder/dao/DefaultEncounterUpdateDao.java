package com.encounter.encounterbuilder.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.encounter.encounterbuilder.entity.Encounter;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultEncounterUpdateDao implements EncounterUpdateDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Encounter updateEncounter(String name, String newName) {
    
    String sql = ""
        + "UPDATE encounter "
        + "SET encounter.encounter_name = :new_name "
        + "WHERE encounter.encounter_name = :encounter_name;";
    log.debug("Dao: renaming encounter {} to {}", name, newName);
    Map<String, Object> params = new HashMap<>();
    
    params.put("new_name", newName);
    params.put("encounter_name", name);
    jdbcTemplate.update(sql, params);
    
    return null;
  }

}
