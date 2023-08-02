package com.allianz.pokemon.database.repository;

import com.allianz.pokemon.database.entity.ArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArenaEntityRepository extends JpaRepository<ArenaEntity, Long> {
	List<ArenaEntity> findByNameStartingWith(String key);
	List<ArenaEntity> findByNameContainsIgnoreCase(String key);
}
