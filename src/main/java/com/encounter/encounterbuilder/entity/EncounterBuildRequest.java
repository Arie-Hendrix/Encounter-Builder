package com.encounter.encounterbuilder.entity;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class EncounterBuildRequest {
  
  // private Long encounterPk;
  private List<@NotNull @Length(max = 30) @Pattern(regexp = "[A-Z0-9_]*") String> monsters;
  private List<@NotNull @Length(max = 30) @Pattern(regexp = "[A-Z_]*") String> characters;
  @NotNull
  @Length(max = 40)
  @Pattern(regexp = "[A-Z0-9_]*")
  private String encounterName;  
}
