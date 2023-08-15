package com.allianz.springlesson.database.repository;

import com.allianz.springlesson.database.entitiy.PersonEntity;
import com.allianz.springlesson.util.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonEntityRepository extends BaseRepository<PersonEntity, Long> { //hangi entity ile çalışacağımızı ve primary keyin tipini belirtiyoruz.
	List<PersonEntity> findAllByNameStartingWith(String key); // select * from person where name like 'key%'

	List<PersonEntity> findAllByNameContainsIgnoreCase(String key); // select * from person where name like '%key%'

	List<PersonEntity> findAllByNameStartingWithOrSurnameStartingWith(String name, String surname); // select * from person where name like 'name%' or surname like 'surname%'

	//sql injection: "select * from person where name like 'name%' or surname like 'surname%' or 1=1" <---- yapıldığı zaman bütün bilgileri alır geçmiş olsun.
	@Query("select p from PersonEntity p where p.name =?1 and p.surname =?2")
	List<PersonEntity> getPersonAllByName(String name, String surname);

	@Query("delete from PersonEntity p where p.name = ?1") //
	void deletePersonByName(String name);

/*	@Modifying //Yazmamız gerekiyor delete yaparken Veriyle oynadığımız anda modified kullanmamız gerekiyor.
	void deleteByUuid(UUID uuid);
	Optional<PersonEntity> findByUuid(UUID uuid);*/
}
