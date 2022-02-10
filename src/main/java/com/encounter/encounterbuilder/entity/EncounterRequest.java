package com.encounter.encounterbuilder.entity;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class EncounterRequest {
  
  private List<@NotNull Monster> monsters;
  private List<@NotNull Character> characters;
  @NotNull
  @Length(max = 60)
  @Pattern(regexp = "[A-Z0-9_]*")
  private String encounterName;  
  
}


//private List<@NotNull @Length(max = 30) @Pattern(regexp = "[A-Z0-9_]*") String> monsters;
//private List<@NotNull @Length(max = 30) @Pattern(regexp = "[A-Z_]*") String> characters;