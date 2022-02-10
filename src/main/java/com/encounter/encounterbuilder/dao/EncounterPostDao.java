package com.encounter.encounterbuilder.dao;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;
import com.encounter.encounterbuilder.entity.Character;

public interface EncounterPostDao {

  Encounter saveEncounter(List<Character> characters, List<Monster> monsters, String encounterName);
  List<Monster> fetchMonsters(List<Monster> monsters);
  List<Character> fetchCharacters(List<Character> characters);

}
