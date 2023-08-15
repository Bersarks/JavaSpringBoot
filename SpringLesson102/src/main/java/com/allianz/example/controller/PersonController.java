/*
package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired // Otomatik olarak Ram'de tuttuğun bu tipteki bir objeye bunu bağla.
    PersonService personService;

    // Endpoint -> Son nokta-Bitiş noktası. Rest servis yazıyorsam, endpoint bunu kullanıcıya sunduğum nokta
    // localhost:8080/example pathi bir endpointtir. browserdan veya postman'den tetikleniyor. yani URL
    // HER API'ımız bir method.
    // Request mapping verdiğimiz için, tüm controller'a path vermiş olduk.
    // Tüm api pathleri example/ ile başlar. localhost:8080/example/person gibi.

    @GetMapping("hello-world")
    public ResponseEntity<String> helloWorldApi() {
        return new ResponseEntity<>("Hello world", HttpStatus.ACCEPTED);
    }

    @GetMapping("person")
    public ResponseEntity<Person> personApi() {
        Person person = new Person();
        person.setName("Furkan");
        person.setSurname("Yalçın");
        person.setBirthYear(1992);
        person.setTc("asdasdasd");
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // Path variable. localhost:8080/person/ sonrasında bir parametre almak istiyorsak kullanılıyor.
    // Parametre olarak mapdeki ile aynı olmak zorunda!
    @GetMapping("person/{personId}")
    public ResponseEntity<Person> personGetPersonByIdApi(@PathVariable int personId) {
        if (personId == 1) {
            Person person = new Person();
            person.setName("Furkan");
            person.setSurname("Yalçın");
            person.setBirthYear(1992);
            person.setTc("asdasdasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            Person person = new Person();
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("zxczxcasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @GetMapping("person-list")
    public ResponseEntity<List<Person>> personGetPersonByIdApi() {
        List<Person> personList = new ArrayList<>();

        Person person1 = new Person();
        person1.setName("Furkan");
        person1.setSurname("Yalçın");
        person1.setBirthYear(1992);
        person1.setTc("asdasdasd");

        Person person2 = new Person();
        person2.setName("Gizem");
        person2.setSurname("Kısa");
        person2.setBirthYear(1992);
        person2.setTc("zxczxcasd");

        personList.add(person1);
        personList.add(person2);

        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

    // Request parameter. URL'e parametre göndererek çalışır. person-by-request-param?personId=2&personName=Mert gibi.
    @GetMapping("person-by-request-param")
    public ResponseEntity<Person> getPersonByIdRequestParamApi(@RequestParam int personId, @RequestParam String tc) {
        System.out.println(tc);
        Person person = new Person();
        if (personId == 1) {
            person.setName("Furkan");
            person.setSurname("Yalçın");
            person.setBirthYear(1992);
            person.setTc("asdasdasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("zxczxcasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @GetMapping("byId")
    public ResponseEntity<PersonEntity> getPersonByIdParam(@RequestParam int id) {
        Person person = new Person();
        if (id == 1) {
            person.setName("Mert");
            person.setSurname("Yıldız");
            person.setBirthYear(1992);
            person.setTc("asdasdasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            person.setName("Tuğçe");
            person.setSurname("Yıldız");
            person.setBirthYear(1992);
            person.setTc("zxczxcasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    @GetMapping("byId/{path}")
    public ResponseEntity<Person> getPersonByIdPath(@PathVariable int path) {
        Person person = new Person();
        if (path == 1) {
            person.setName("Furkan");
            person.setSurname("Yalçın");
            person.setBirthYear(1992);
            person.setTc("asdasdasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            person.setName("Gizem");
            person.setSurname("Kısa");
            person.setBirthYear(1992);
            person.setTc("zxczxcasd");
            return new ResponseEntity<>(person, HttpStatus.OK);
        }
    }

    // Get ve Post için aynı path'leri kullanabiliriz. Çakışma olmayacaktır. Tüm parametreler dahil olacağından RequestBody
    // PostMan'den body kısmından JSON olarak göndermek gerekir. Body kısmı SSL sertifikası ile şifreleniyor(Hem requestler
    // hem de response'lar şifrelenmiş oluyor).
    @PostMapping("person")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody Person person) {
        PersonEntity person1 = personService.createPerson(person.getName(), person.getSurname(),
                person.getTc(), person.getBirthYear());

//        throw new Exception("asd"); -> Server error verir, yani 500lü bir hata. Program çalışmaya devam eder.
        return new ResponseEntity<>(person1, HttpStatus.OK);
    }

    @PutMapping("person/{tc}")
    public ResponseEntity<Person> createPerson(@RequestBody Person person, @PathVariable String tc) {
        List<Person> personList = new ArrayList<>();
        Person personExist = new Person();
        personExist.setTc("9999");
        personExist.setName("Furkan");
        personExist.setSurname("Yalçındağ");
        personExist.setBirthYear(1992);

        personList.add(personExist);

        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getTc().equals(tc)) {
                personList.get(i).setTc(person.getTc());
                personList.get(i).setName(person.getName());
                personList.get(i).setSurname(person.getSurname());
                personList.get(i).setBirthYear(person.getBirthYear());

                return new ResponseEntity<>(personList.get(i), HttpStatus.CREATED);
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("person/{uuid}")
    public ResponseEntity<Boolean> createPerson(@PathVariable UUID uuid) {
        Boolean isDeleted = personService.deletePersonByUUID(uuid);

        if (isDeleted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);

        }

    }

    @GetMapping("person-list-by-name-start-with/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameStartWith(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameStartsWith(key), HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-contains/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameIContains(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonListByNameIContains(key), HttpStatus.OK);
    }

    @GetMapping("person-list-by-name-surname-start-with/name/{name}/surname/{surname}") // Doğru path bu şekilde
    public ResponseEntity<List<PersonEntity>> getPersonListByNameIContains(@PathVariable String name,
                                                                           @PathVariable String surname) {
        return new ResponseEntity<>(personService.getPersonNameStartWithOrSurnameStartWith(name, surname),
                HttpStatus.OK);
    }

    @GetMapping("person-by-uuid/{uuid}")
    public ResponseEntity<PersonEntity> getPersonByUUID(@PathVariable UUID uuid) {
        PersonEntity personEntity = personService.getPersonByUUID(uuid);
        if (personEntity != null) {
            return new ResponseEntity<>(personEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("person-update/{uuid}")
    public ResponseEntity<PersonEntity> updatePersonByUUID(@PathVariable UUID uuid,
                                                           @RequestBody PersonEntity newPersonEntity) {

        PersonEntity personEntity = personService.updatePersonByUUID(uuid, newPersonEntity);

        if (personEntity != null) {
            return new ResponseEntity<>(personEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


}
*/
