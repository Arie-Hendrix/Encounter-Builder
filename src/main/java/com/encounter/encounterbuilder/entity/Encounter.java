package com.encounter.encounterbuilder.entity;

import java.util.Comparator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Encounter implements Comparable<Encounter>{

  private Long encounterPK;
  private String encounterName;
  private List<Monster> monsters;
  private List<Character> characters;
  
  @JsonIgnore
  public Long getEncounterPK() {
    return encounterPK;
  }

  @Override
  public int compareTo(Encounter e) {
    
    return Comparator.comparing(Encounter::getEncounterName).compare(this, e);
  }
  
}
