package com.allianz.springlesson.service;

import com.allianz.springlesson.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
// Javadaki beanler ile oluşturuluyor
@Service // bu classın servis olduğunu belirtiyoruz. Program ayağa kalkarken bu serviceleri bulup hepsinden bir obje oluşturuyor.
public class PersonService {
	@Value("${gizem:65}")
	int value;
	public Person createPerson(String name, String surname, int birthYear, String tc) {
		Person person = new Person();
		person.setName(name);
		person.setSurname(surname);
		person.setBirthYear(birthYear);
		person.setTc(tc);
		System.out.println(value);
		return person;
	}
}
