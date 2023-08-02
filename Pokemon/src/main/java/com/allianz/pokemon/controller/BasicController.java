package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.CharacterEntity;
import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.service.CharacterService;
import com.allianz.pokemon.service.PokemonService;
import com.allianz.pokemon.util.dbutil.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BasicController {
	@Autowired
	PokemonService pokemonService;
	@Autowired
	CharacterService characterService;

	@GetMapping("/{key}")
	public ResponseEntity<List<BaseEntity>> getRequestedData(@PathVariable String key) {
		String[] keySplit = key.split("-");
		List<BaseEntity> result = new ArrayList<>();
		for (PokemonEntity p : pokemonService.getAllPokemons())
			for (int i = 0; i < keySplit.length; i++)
				if (keySplit[i].toLowerCase().contains(p.getName().toLowerCase())) {
					result.add(p);
					break;
				}
		for (CharacterEntity c : characterService.getAllCharacter())
			for(int i = 0; i < keySplit.length; i++)
				if (keySplit[i].toLowerCase().contains(c.getName().toLowerCase())) {
					result.add(c);
					break;
				}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
