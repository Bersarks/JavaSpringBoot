package com.allianz.pokemon.database.repository;

import com.allianz.pokemon.database.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {
	List<CharacterEntity> findByNameStartingWith(String key);
	List<CharacterEntity> findByNameContainsIgnoreCase(String key);
}
