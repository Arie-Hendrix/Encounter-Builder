package com.encounter.encounterbuilder.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEncounterDeleteDao implements EncounterDeleteDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public void deleteEcnounter(String name) {
    String sql = ""
        + "DELETE FROM encounter "
        + "WHERE encounter_name = :encounter_name;";
    
    Map<String, Object> params = new HashMap<>();
    
    params.put("encounter_name", name);
    
    int check = jdbcTemplate.update(sql, params);
    if (check != 0) {
      
    }else {
      throw new NoSuchElementException("There was no encounter with that name");
    }
      
  }

}
