package com.allianz.springlesson.service;

import com.allianz.springlesson.database.entitiy.PersonEntity;
import com.allianz.springlesson.database.repository.IPersonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Javadaki beanler ile oluşturuluyor
@Service
// bu classın servis olduğunu belirtiyoruz. Program ayağa kalkarken bu serviceleri bulup hepsinden bir obje oluşturuyor.
public class PersonService {
	@Value("${gizem:65}")
	int value;

	@Autowired // bu anotasyon ile spring bu classı bulup bir obje oluşturuyor ve bu objeyi buraya enjekte ediyor.
	IPersonEntityRepository personEntityRepository;

	public PersonEntity createPerson(String name, String surname, int birthYear, String tc) {
		PersonEntity person = new PersonEntity();
		person.setName(name);
		person.setSurname(surname);
		person.setBirthYear(birthYear);
		person.setTc(tc);
		personEntityRepository.save(person); // aynı id ile eşlecen veri varsa update ediyor yoksa yenisini ekliyor.
		System.out.println(value);
		return person;
	}

	public List<PersonEntity> getPerson(String key) {
		return personEntityRepository.findAllByNameStartingWith(key);
	}

	public List<PersonEntity> getPersonIContains(String key) {
		return personEntityRepository.findAllByNameContainsIgnoreCase(key);
	}

	public List<PersonEntity> getPersonNameOrSurname(String name, String surname) {
		return personEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
	}

	public PersonEntity getPersonByUUID(UUID uuid) {
		Optional<PersonEntity> personEntityOptional = personEntityRepository.findByUuid(uuid);

		return personEntityOptional.orElse(null);
	}
/*	public PersonEntity getPersonByUUID(UUID uuid) {
		Optional<PersonEntity> personEntity = personEntityRepository.findByUuid(uuid); // Optional nesne var da olabilir null da olabilir.
		return personEntity.orElse(null); // bunu koşula bakmadan yaparsak NullPointerException hatası alırız.
	}*/

	//Kritik işlemlerde Transactional koyarak db ile kod arasında işlemin düzgünlüğünü kontrol ediyoruz.
	@Transactional // ya hep ya hiç hata varsa kaydeder hata yoksa o ana kadar yaptığı her şeyi geri alır.
	public PersonEntity updatePersonByUUID(UUID uuid, PersonEntity newPersonEntity) {
		PersonEntity personEntity = getPersonByUUID(uuid);
		if (personEntity != null) {
			personEntity.setName(newPersonEntity.getName());
			personEntity.setSurname(newPersonEntity.getSurname());
			personEntity.setTc(newPersonEntity.getTc());
			personEntity.setBirthYear(newPersonEntity.getBirthYear());
			personEntityRepository.save(personEntity);
			return personEntity;
		} else
			return null;
	}

	@Transactional
	public Boolean deletePersonByUUID(UUID uuid) {
		PersonEntity personEntity = getPersonByUUID(uuid);
		if (personEntity != null) {
			personEntityRepository.deleteByUuid(uuid);
			return true;
		} else {
			return false;
		}
	}
}
