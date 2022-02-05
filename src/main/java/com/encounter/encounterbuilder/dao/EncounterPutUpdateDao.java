package com.encounter.encounterbuilder.dao;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import com.encounter.encounterbuilder.entity.Encounter;
import com.encounter.encounterbuilder.entity.Monster;

public interface EncounterPutUpdateDao {

  Encounter saveEncounter(List<Character> characters, List<Monster> monsters, String encounterName);

  String fetchEncounterName(String encounterName);

  List<Monster> fetchMonsters(List<String> monsters);

  List<Character> fetchCharacters(List<String> characters);

}
