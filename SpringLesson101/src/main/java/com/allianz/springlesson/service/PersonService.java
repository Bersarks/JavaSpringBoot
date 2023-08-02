package com.allianz.springlesson.service;

import com.allianz.springlesson.database.entitiy.PersonEntity;
import com.allianz.springlesson.database.repository.IPersonEntityRepository;
import com.allianz.springlesson.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

// Javadaki beanler ile oluşturuluyor
@Service // bu classın servis olduğunu belirtiyoruz. Program ayağa kalkarken bu serviceleri bulup hepsinden bir obje oluşturuyor.
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
		personEntityRepository.save(person);
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
}
