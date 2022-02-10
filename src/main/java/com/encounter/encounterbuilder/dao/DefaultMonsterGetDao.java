package com.encounter.encounterbuilder.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.encounter.encounterbuilder.entity.CreatureType;
import com.encounter.encounterbuilder.entity.Monster;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultMonsterGetDao implements MonsterGetDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Monster> getMonstersOfType(CreatureType type) {
    log.debug("DAO: getting all monsters of type {}", type);
    
    String sql = "SELECT * " +
        "FROM monster m " +
        "WHERE type = :type " +
        "ORDER BY name";
    
    Map<String, Object> params = new HashMap<>();
    params.put("type", type.toString());
    
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
}
