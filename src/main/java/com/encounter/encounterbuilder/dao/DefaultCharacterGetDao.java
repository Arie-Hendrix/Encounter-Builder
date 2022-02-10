package com.encounter.encounterbuilder.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.CreatureType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCharacterGetDao implements CharacterGetDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Character> getCharacters() {
    log.debug("DAO: getting all characters");
    
    String sql = "SELECT * " +
        "FROM character_table ct " +
        "ORDER BY name";
    
   return jdbcTemplate.query(sql, new RowMapper<>() {

     @Override
     public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
       return Character.builder()
           .characterId(rs.getLong("character_id"))
           .playerId(rs.getLong("player_id"))
           .characterName(rs.getString("name"))
           .type(CreatureType.valueOf(rs.getString("type")))
           .level(rs.getInt("level"))
           .armorClass(rs.getInt("armor_class"))
           .hp(rs.getInt("hit_points"))
           .build();
     }});
  }

}
