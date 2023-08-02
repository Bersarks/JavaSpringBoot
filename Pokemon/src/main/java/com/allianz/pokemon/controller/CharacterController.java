package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.CharacterEntity;
import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
	@Autowired
	CharacterService characterService;

	@PostMapping("/create")
	public ResponseEntity<CharacterEntity> createChar(@RequestBody CharacterEntity character) {
		return ResponseEntity.ok(characterService.createChar(character.getName(), character.getStrategy(),
				character.getBonusDamage()));
	}

	@GetMapping("/search-by-name/{key}")
	public ResponseEntity<List<CharacterEntity>> searchPokemon(@PathVariable String key) {
		return ResponseEntity.ok(characterService.getCharacterByName(key));
	}

	@GetMapping("/all")
	public ResponseEntity<List<CharacterEntity>> getAllCharacter() {
		return ResponseEntity.ok(characterService.getAllCharacter());
	}

	@GetMapping("/search-by-name-contains/{key}")
	public ResponseEntity<List<CharacterEntity>> searchCharacterNameContains(@PathVariable String key) {
		return ResponseEntity.ok(characterService.getCharacterByNameContains(key));
	}
}
