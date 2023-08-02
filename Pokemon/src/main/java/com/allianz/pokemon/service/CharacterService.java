package com.allianz.pokemon.service;

import com.allianz.pokemon.database.entity.CharacterEntity;
import com.allianz.pokemon.database.repository.ICharacterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
	@Autowired
	ICharacterEntityRepository characterEntityRepository;

	public CharacterEntity createChar(String name, String strategy, int bonusDamage) {
		CharacterEntity character = new CharacterEntity();
		character.setName(name);
		character.setStrategy(strategy);
		character.setBonusDamage(bonusDamage);
		characterEntityRepository.save(character);
		return character;
	}

	public List<CharacterEntity> getAllCharacter() {
		return characterEntityRepository.findAll();
	}

	public List<CharacterEntity> getCharacterByNameContains(String key) {
		return characterEntityRepository.findByNameContainsIgnoreCase(key);
	}

	public List<CharacterEntity> getCharacterByName(String key) {
		return characterEntityRepository.findByNameStartingWith(key);
	}
}
