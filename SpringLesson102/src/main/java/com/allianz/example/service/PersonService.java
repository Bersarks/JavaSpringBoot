package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Service anotasyonu, Program ayağa kalkarken bütün servis class'larını bulup 1'er tane obje oluşturuyor.
// Program boyunca aynı objeyi kullanıyoruz. Buna "bean" yapısı deniyor, javadaki beanlerle sağlanıyor. Programın
// lifecycle süresince bunlar kullanılıyor. 10000 tane servis oluşturmaya gerek kalmıyor.
@Service
public class PersonService {
    @Value("${gizem:25}") // Application properties içerisindeki key'e erişmek için. gizeme karşılık gelen value yoksa defaultu 25
    int value;

    @Autowired
    PersonEntityRepository personEntityRepository;

    public PersonEntity createPerson(String name, String surname, String tc, int birthYear) {
        PersonEntity person = new PersonEntity();
        person.setBirthYear(birthYear);
        person.setName(name);
        person.setSurname(surname);
        person.setTc(tc);

        personEntityRepository.save(person);

        System.out.println(value);

        return person;
    }

    public List<PersonEntity> getPersonNameStartsWith(String key) {
        return personEntityRepository.findAllByNameStartingWith(key);
    }

    public List<PersonEntity> getPersonListByNameIContains(String containsKey) {
        return personEntityRepository.findAllByNameContainsIgnoreCase(containsKey);
    }

    public List<PersonEntity> getPersonNameStartWithOrSurnameStartWith(String name, String surname) {
        return personEntityRepository.findAllByNameStartingWithOrSurnameStartingWith(name, surname);
    }

    public PersonEntity getPersonByUUID(UUID uuid) {
        Optional<PersonEntity> personEntityOptional = personEntityRepository.findByUuid(uuid);

        return personEntityOptional.orElse(null);
    }

    public PersonEntity updatePersonByUUID(UUID uuid, PersonEntity newPersonEntity) {
        PersonEntity personEntity = new PersonEntity();
        if (newPersonEntity != null) {
            personEntity.setName(newPersonEntity.getName());
            personEntity.setSurname(newPersonEntity.getSurname());
            personEntity.setBirthYear(newPersonEntity.getBirthYear());
            personEntity.setTc(newPersonEntity.getTc());

            personEntityRepository.save(personEntity);

            return personEntity;
        } else {
            return null;
        }
    }

    public boolean deletePersonByUUID(UUID uuid) {
        PersonEntity personEntity = getPersonByUUID(uuid);
        if (personEntity != null) {
            personEntityRepository.deleteByUuid(uuid);
            return true;
        } else {
            return false;
        }
    }


}
