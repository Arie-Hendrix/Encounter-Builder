package com.encounter.encounterbuilder.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.encounter.encounterbuilder.entity.Character;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEncounterPostDao implements EncounterPostDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public Encounter saveEncounter(List<Character> characters, List<Monster> monsters,
      String encounterName) {
    log.debug("DAO: saveEncounter called");
    SqlParams params = generateEncounterInsertSql(encounterName);
    
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    Long encounterID = keyHolder.getKey().longValue();
    saveCharacters(characters, encounterID);
    saveMonsters(monsters, encounterID);
    
    return Encounter.builder()
        .encounterPK(encounterID)
        .encounterName(encounterName)
        .monsters(monsters)
        .characters(characters)
        .build();
  }
  
  private SqlParams generateEncounterInsertSql(String encounterName) {
    SqlParams params = new SqlParams();
    params.sql = ""
        + "INSERT INTO encounter (encounter_name) "
        + "VALUES (:encounter_name);";
    params.source.addValue("encounter_name", encounterName);
    return params;
  }

  private void saveMonsters(List<Monster> monsters, Long encounterID) {
      for (Monster monster : monsters) {
        SqlParams params = generateMonsterInsertSql(monster, encounterID);
        jdbcTemplate.update(params.sql, params.source);
      }
  }
  
  private SqlParams generateMonsterInsertSql(Monster monster, Long encounterID) {
    SqlParams params = new SqlParams();
    params.sql = ""
        + "INSERT INTO encounter_monster "
        + "(encounter_id, monster_id) "
        + "VALUES (:encounter_id, :monster_id)";
    
    params.source.addValue("monster_id", monster.getMonsterId());
    params.source.addValue("encounter_id", encounterID);
    return params;
  }
  
  private void saveCharacters(List<Character> characters, Long encounterID) {
    for (Character character : characters) {
      SqlParams params = generateCharacterInsertSql(character, encounterID);
      jdbcTemplate.update(params.sql, params.source);
    }    
  }
  
  private SqlParams generateCharacterInsertSql(Character character, Long encounterID) {
    SqlParams params = new SqlParams();
    params.sql = ""
        + "INSERT INTO encounter_character "
        + "(encounter_id, character_id) "
        + "VALUES (:encounter_id, :character_id)";
    
    params.source.addValue("character_id", character.getCharacterId());
    params.source.addValue("encounter_id", encounterID);
    return params;
  }

  @Override
  public List<Monster> fetchMonsters(List<Long> monsters) {
    if (monsters.isEmpty()) {
      return new LinkedList<>();
    }
    Map<String, Object> params = new HashMap<>();
    
    String sql = "SELECT * FROM "
               + "monster WHERE "
               + "monster_id IN(";
    
    for (int index = 0; index < monsters.size(); index++) {
      String key = "monster_" + index;
      sql += ":" + key + ", ";
      params.put(key, monsters.get(index));
    }
    sql = sql.substring(0, sql.length() - 2);
    sql += ")";

    return jdbcTemplate.query(sql, params, new RowMapper<Monster>() {
      @Override
      public Monster mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Monster.builder()
            .monsterId(rs.getLong("monster_id"))
            .monsterName(rs.getString("name"))
            .type(CreatureType.valueOf(rs.getString("type")))
            .cr(rs.getBigDecimal("challenge_rating"))
            .armorClass(rs.getInt("armor_class"))
            .hp(rs.getInt("hit_points"))
            .build();
      }
    });
    
  }

  @Override
  public List<Character> fetchCharacters(List<Long> characters) {
    if (characters.isEmpty()) {
      return new LinkedList<>();
    }
    Map<String, Object> params = new HashMap<>();
    
    String sql = "SELECT * FROM "
               + "character_table WHERE "
               + "character_id IN(";
    
    for (int index = 0; index < characters.size(); index++) {
      String key = "character_" + index;
      sql += ":" + key + ", ";
      params.put(key, characters.get(index));
    }
    sql = sql.substring(0, sql.length() - 2);
    sql += ")";

    return jdbcTemplate.query(sql, params, new RowMapper<Character>() {
      @Override
      public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Character.builder()
            .characterId(rs.getLong("character_id"))
            .playerId(rs.getLong("player_id"))
            .characterName(rs.getString("name"))
            .type(CreatureType.valueOf(rs.getString("type")))
            .armorClass(rs.getInt("armor_class"))
            .hp(rs.getInt("hit_points"))
            .level(rs.getInt("level"))
            .build();
      }
    });
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
}
