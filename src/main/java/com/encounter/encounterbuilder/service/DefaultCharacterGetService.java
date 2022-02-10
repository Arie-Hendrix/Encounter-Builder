package com.encounter.encounterbuilder.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.encounter.encounterbuilder.dao.CharacterGetDao;
import com.encounter.encounterbuilder.entity.Character;

@Service
public class DefaultCharacterGetService implements CharacterGetService{

  @Autowired
  private CharacterGetDao characterDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Character> fetchAllPlayerCharacters() {
    List<Character> characters = characterDao.getCharacters();
    if(characters.isEmpty()) {
      String msg = String.format("No characters found");
      throw new NoSuchElementException(msg);
    }
    return characters;
  }

}
