package com.encounter.encounterbuilder.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultEncounterGetDao implements EncounterGetDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Encounter> displayEncounter(long encounterPk) {
    log.debug("DAO: encounter= {}", encounterPk);
   
    String sql = ""
        + "SELECT * "
        + "FROM encounters "
        + "WHERE encounter_id = :encounter_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("encounter_id", encounterPk);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Encounter mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return Encounter.builder()
//            .characters(null)
//            .build();
        return null;
      }});
  }

  @Override
  public List<Encounter> displayEncounter(String encounterName) {
    log.debug("DAO: encounter= {}", encounterName);
    
    String sql = ""
        + "SELECT * "
        + "FROM encounters "
        + "WHERE encounter_name = :encounter_name";
    Map<String, Object> params = new HashMap<>();
    params.put("encounter_name", encounterName);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Encounter mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return Encounter.builder()
//            .characters(null)
//            .build();
        return null;
      }});
  }

  @Override
  public List<Monster> displayMonstersOfType(CreatureType type) {
    log.debug("DAO: monster type= {}", type);
    
    String sql = ""
        + "SELECT * "
        + "FROM monsters "
        + "WHERE monster_type = :monster_type";
    
    Map<String, Object> params = new HashMap<>();
    params.put("monster_type", type);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Monster.builder()
            .monsterId(rs.getLong("monster_id"))
            .monsterName(rs.getString("name"))
            .type(CreatureType.valueOf(rs.getString("type")))
            .cr(new BigDecimal(rs.getString("challenge_rating")))
            .armorClass(rs.getInt("armor_class"))
            .hp(rs.getInt("hit_points"))
            .build();
      }});
  }
  
  @Override
  public List<Character> displayPlayerCharacters(String firstName, String lastName) {
    log.debug("DAO: characters from player {} {}", firstName, lastName);
    
    String sql = ""
        + "SELECT * "
        + "FROM charcter_table INNER JOIN player "
        + "WHERE player.player_id = character_table.player_id "
        + "AND player.first_name = :first_name "
        + "AND player.last_name = :last_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      @Override
      public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Character.builder()
            .characterName(rs.getString("name"))
            .type(CreatureType.valueOf(rs.getString("type")))
            .level(rs.getInt("level"))
            .armorClass(rs.getInt("armor_class"))
            .hp(rs.getInt("hit_points"))
            .build();
      }});
  }

  @Override
  public List<Encounter> displayEncounters() {
    
    return null;
  }
}