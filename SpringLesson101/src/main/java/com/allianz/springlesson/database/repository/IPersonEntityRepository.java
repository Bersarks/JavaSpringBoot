package com.allianz.springlesson.database.repository;

import com.allianz.springlesson.database.entitiy.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonEntityRepository extends JpaRepository<PersonEntity, Long> { //hangi entity ile çalışacağımızı ve primary keyin tipini belirtiyoruz.
	List<PersonEntity> findAllByNameStartingWith(String key); // select * from person where name like 'key%'
	List<PersonEntity> findAllByNameContainsIgnoreCase(String key); // select * from person where name like '%key%'
	List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname); // select * from person where name like 'name%' or surname like 'surname%'

}