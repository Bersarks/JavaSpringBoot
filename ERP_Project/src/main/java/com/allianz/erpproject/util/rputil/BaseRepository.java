package com.allianz.erpproject.util.rputil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID> {
	List<T> findAllByNameStartingWith(String key);
	List<T> findAllByNameContainsIgnoreCase(String key);
	void deleteByUuid(UUID uuid);
	Optional<T> findByUuid(UUID uuid);
}
