package com.allianz.pokemon.controller;

import com.allianz.pokemon.database.entity.ArenaEntity;
import com.allianz.pokemon.service.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arena")
public class ArenaController {
	@Autowired
	ArenaService arenaService;

	@PostMapping("/create")
	public ResponseEntity<ArenaEntity> createArena(@RequestBody ArenaEntity arena) {
		return ResponseEntity.ok(arenaService.createArena(arena.getName(), arena.getLocation(),
				arena.getCapacity(), arena.getWeatherType()));
	}

	@GetMapping("/search-by-name/{key}")
	public ResponseEntity<List<ArenaEntity>> searchArena(@PathVariable String key){
		return ResponseEntity.ok(arenaService.getArenaByName(key));
	}

	@GetMapping("/all")
	public ResponseEntity<List<ArenaEntity>> getAllArena(){
		return ResponseEntity.ok(arenaService.getAllArena());
	}

	@GetMapping("/search-by-name-contains/{key}")
	public ResponseEntity<List<ArenaEntity>> searchArenaContains(@PathVariable String key){
		return ResponseEntity.ok(arenaService.getArenaByNameContains(key));
	}
}
