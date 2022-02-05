package com.encounter.encounterbuilder.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

  private Long playerId;
  private String firstName;
  private String lastName;
}
