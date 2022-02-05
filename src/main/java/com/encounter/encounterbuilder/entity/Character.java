package com.encounter.encounterbuilder.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Character {

  private Long characterId;
  private String characterName;
  @Builder.Default
  private CreatureType type = CreatureType.HUMANOID;
  private int armorClass;
  private int hp;
  private int level;
}
