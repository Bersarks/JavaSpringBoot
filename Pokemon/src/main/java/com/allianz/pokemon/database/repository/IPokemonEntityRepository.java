package com.allianz.pokemon.database.repository;

import com.allianz.pokemon.database.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPokemonEntityRepository extends JpaRepository<PokemonEntity, Long> {
	List<PokemonEntity> findByNameStartingWith(String key);

	List<PokemonEntity> findByNameContainsIgnoreCase(String key);
}
