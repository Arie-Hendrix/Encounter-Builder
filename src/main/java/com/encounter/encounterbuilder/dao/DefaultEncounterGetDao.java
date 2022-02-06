package com.encounter.encounterbuilder.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

  
  @SuppressWarnings("unchecked")
  @Override
  public List<Encounter> getEncounter(String encounterName) {
    log.debug("DAO: encounter name ={}", encounterName);
    
    String sql = "SELECT * " +
        "FROM encounter " +
        "WHERE encounter_name = :encounter_name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("encounter_name", encounterName.toString());
    
    List<Encounter> encounters = new LinkedList<>();
    Encounter encounter = jdbcTemplate.query(sql, params, new ResultSetExtractor<Encounter>() {
      
      public Encounter extractData(ResultSet rs) throws SQLException, DataAccessException {
       if(rs.next()) {
        return Encounter.builder()
            .encounterPK(rs.getLong("encounter_id"))
            .encounterName(rs.getString("encounter_name"))
            .build();
       }
       return null;
      }});

      encounter.setMonsters(getMonsters((encounter).getEncounterPK()));
      encounter.setCharacters(getPlayerCharacters((encounter).getEncounterPK()));
      encounters.add(encounter);
    //   getMonsters(encounter.getEncounterPK());
    //   getPlayerCharacters(encounter.getEncounterPK());
   
     return encounters;
    }
  
  

  @Override
  public List<Monster> getMonsters(Long encounterId) {
    log.debug("DAO: getting monsters for encounter ID ={}", encounterId);
    
//    String sql = "SELECT * " +
//          "FROM monsters m INNER JOIN encounter_monster em " 
//        + "USING monster_id "
//        + "WHERE em.encounter_id = :encounter_id";
      String sql = "SELECT * FROM monster m "
          + "INNER JOIN encounter_monster em "
          + "WHERE m.monster_id = em.monster_id "
          + "AND em.encounter_id = :encounter_id";
        
    
    
    Map<String, Object> params = new HashMap<>();
    params.put("encounter_id", encounterId);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
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
  public List<Character> getPlayerCharacters(Long encounterId) {
    log.debug("DAO: getting characters for encounter ID ={}", encounterId);
    
    String sql = "SELECT * " +
          "FROM character_table ct "
        + "INNER JOIN encounter_character ec "
        + "WHERE ct.character_id = ec.character_id "
        + "AND ec.encounter_id = :encounter_id";
    
    Map<String, Object> params = new HashMap<>();
    params.put("encounter_id", encounterId.toString());
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      
      public Character mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Character.builder()
            .characterId(rs.getLong("character_id"))
            .characterName(rs.getString("name"))
            .playerId(rs.getLong("player_id"))
            .type(CreatureType.HUMANOID)
            .level(rs.getInt("level"))
            .armorClass(rs.getInt("armor_class"))
            .hp(rs.getInt("hit_points"))
            .build();
      }});
  }
  
  
  
  }
