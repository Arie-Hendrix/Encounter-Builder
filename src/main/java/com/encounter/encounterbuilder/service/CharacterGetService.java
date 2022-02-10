package com.encounter.encounterbuilder.service;

import java.util.List;
import com.encounter.encounterbuilder.entity.Character;

public interface CharacterGetService {

  List<Character> fetchAllPlayerCharacters();
}
