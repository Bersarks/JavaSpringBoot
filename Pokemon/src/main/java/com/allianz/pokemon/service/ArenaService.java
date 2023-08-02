package com.allianz.pokemon.service;

import com.allianz.pokemon.database.entity.ArenaEntity;
import com.allianz.pokemon.database.repository.IArenaEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {
	@Autowired
	IArenaEntityRepository arenaEntityRepository;
	public ArenaEntity createArena(String name, String location, int capacity, String weatherType){
		ArenaEntity arena = new ArenaEntity();
		arena.setName(name);
		arena.setLocation(location);
		arena.setCapacity(capacity);
		arena.setWeatherType(weatherType);
		arenaEntityRepository.save(arena);
		return arena;
	}
	public List<ArenaEntity> getAllArena(){
		return arenaEntityRepository.findAll();
	}
	public List<ArenaEntity> getArenaByNameContains(String key){
		return arenaEntityRepository.findByNameContainsIgnoreCase(key);
	}

	public List<ArenaEntity> getArenaByName(String key){
		return arenaEntityRepository.findByNameStartingWith(key);
	}
}
