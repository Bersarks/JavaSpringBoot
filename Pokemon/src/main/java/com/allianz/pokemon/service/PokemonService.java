package com.allianz.pokemon.service;

import com.allianz.pokemon.database.entity.PokemonEntity;
import com.allianz.pokemon.database.repository.IPokemonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
	@Autowired
	IPokemonEntityRepository pokemonEntityRepository;

	public PokemonEntity createPokemon(String name, String type, String weakness, String ability, int damage) {
		PokemonEntity pokemon = new PokemonEntity();
		pokemon.setName(name);
		pokemon.setType(type);
		pokemon.setWeakness(weakness);
		pokemon.setAbility(ability);
		pokemon.setDamage(damage);
		pokemonEntityRepository.save(pokemon);
		return pokemon;
	}

	public List<PokemonEntity> getAllPokemons() {
		return pokemonEntityRepository.findAll();
	}

	public List<PokemonEntity> getPokemonByNameContains(String key) {
		return pokemonEntityRepository.findByNameContainsIgnoreCase(key);
	}

	public List<PokemonEntity> getPokemonByName(String key) {
		return pokemonEntityRepository.findByNameStartingWith(key);
	}
}
