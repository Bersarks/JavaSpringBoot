package com.allianz.example.database.repository;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonEntityRepository extends IBaseRepository<PersonEntity, Long> {
    List<PersonEntity> findAllByNameStartingWith(String key);
    List<PersonEntity> findAllByNameContainsIgnoreCase(String key);
    List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname);

    // SQL Injection
    @Query("SELECT p FROM PersonEntity p WHERE p.name = ?1 AND p.surname = ?2")
    List<PersonEntity> getPersonAllByName(String name, String surname);

    @Query("DELETE FROM PersonEntity p WHERE p.name = ?1")
    void deletePersonByName(String name);

}
