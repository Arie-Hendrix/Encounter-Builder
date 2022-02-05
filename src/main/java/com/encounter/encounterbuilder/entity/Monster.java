package com.encounter.encounterbuilder.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Monster {

  private Long monsterId;
  private String monsterName;
  private CreatureType type;
  private BigDecimal cr;
  private int armorClass;
  private int hp;
 
}
