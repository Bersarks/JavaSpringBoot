package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonService pokemonService;

	@PostMapping("/create")
	public ResponseEntity<PokemonEntity> createPokemon(@RequestBody PokemonEntity pokemon) {
		return ResponseEntity.ok(pokemonService.createPokemon(pokemon.getName(), pokemon.getType(),
				pokemon.getWeakness(), pokemon.getAbility(), pokemon.getDamage()));
	}

	@GetMapping("/search-by-name/{key}")
	public ResponseEntity<List<PokemonEntity>> searchPokemon(@PathVariable String key) {
		return ResponseEntity.ok(pokemonService.getPokemonByName(key));
	}

	@GetMapping("/all")
	public ResponseEntity<List<PokemonEntity>> getAllPokemons() {
		return ResponseEntity.ok(pokemonService.getAllPokemons());
	}

	@GetMapping("/search-by-name-contains/{key}")
	public ResponseEntity<List<PokemonEntity>> searchPokemonNameContains(@PathVariable String key) {
		return ResponseEntity.ok(pokemonService.getPokemonByNameContains(key));
	}
}
