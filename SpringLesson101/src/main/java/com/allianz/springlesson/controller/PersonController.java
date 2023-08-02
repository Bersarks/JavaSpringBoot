package com.allianz.springlesson.controller;

import com.allianz.springlesson.model.Person;
import com.allianz.springlesson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // bunu reste controller olduğunu bildirmek için bunu koymamız gerekiyor! *****************
@RequestMapping("person") // localhost:8080/api üzerinden request atılabilir.
public class PersonController {
	// Endpoint --> bitiş noktası, son nokta. URL yani kullanıcıya verilen adres.
	// localhost:8080/ --> localhost:8080/hello-world.html üzerinden request atılabiliyor.

	@Autowired // Bean olarak bellekte bulunan aynı objeyi kullanıyor. PersonService personService = new PersonService(); ile aynı şey.
	PersonService personService;

	@GetMapping("hello-world") // bursaı url deki endpoint
	public ResponseEntity<String> index() { // ResponseEntity veriyi arkada json formatına çevirip kullanıcıya o şekilde gönderir.
		return new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
	}

	@GetMapping("person")
	public ResponseEntity<Person> personAPI() {

		Person person = new Person();
		person.setName("Mehmet");
		person.setSurname("Kaya");
		person.setBirthYear(1990);
		person.setTc("199992323");

		return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
	}

	//pathVariable --> url deki değişkenleri almak için kullanılır. localhost:8080/api/person/1

	@GetMapping("person/{personId}")
	public ResponseEntity<List<Person>> personsAPI(@PathVariable("personId") int personId) { // içerdeki parametrenin adı yukarıda tanımlanan ile aynı olmak zorunda.
		Person person = new Person();
		person.setName("Mehmet");
		person.setSurname("Kaya");
		person.setBirthYear(1990);
		person.setTc("199992323");

		Person person1 = new Person();
		person1.setName("Gizem");
		person1.setSurname("Kaya");
		person1.setBirthYear(1990);
		person1.setTc("199992323");

		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person);
		return new ResponseEntity<>(personList, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
	}

	@GetMapping("person-by-request-param")
	public ResponseEntity<List<Person>> getPerson(@RequestParam int personId, @RequestParam int tc) { // burada urlden gelen parametreleri alıyoruz. ona göre veri gönderimi yapıyoruz.

		System.out.println("personId: " + personId);
		System.out.println("tc: " + tc);

		Person person = new Person();
		person.setName("Mehmet");
		person.setSurname("Kaya");
		person.setBirthYear(1990);
		person.setTc("199992323");

		Person person1 = new Person();
		person1.setName("Gizem");
		person1.setSurname("Kaya");
		person1.setBirthYear(1990);
		person1.setTc("199992323");

		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person);
		//return new ResponseEntity<>(personList, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
		return ResponseEntity.ok(personList);
	}

	// direkt olarak objeyi alabiliyoruz bu şekilde. json formatında geliyor. Key value pairleri aynı isim olması en iyi durum.
	// SSL sertifikası varsa o şifrelenmiş bir şekilde veriler ilerler.
	@PostMapping("person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) throws Exception { // body olarak aldığımızda veri paket halinde geliyor. bu yüzden requestbody kullanıyoruz.
		Person person1 = personService.createPerson(person.getName(), person.getSurname(),
				person.getBirthYear(), person.getTc());
		//throw new Exception("Hata oluştu");
		return ResponseEntity.ok(person1);
	}


	/*PathVariable ile url den direkt veriyi alıyoruz
	 * RequestParam ile ?tc=asdasd gibi bir atama yapılması gerekiyor.
	 * */
	@PutMapping("person/{tc}")
	public ResponseEntity<Person> searchPerson(@RequestBody Person person, @PathVariable("tc") String tc) { // body olarak aldığımızda veri paket halinde geliyor. bu yüzden requestbody kullanıyoruz.
		List<Person> personList = new ArrayList<>();
		Person person1 = new Person();
		person1.setName("Gizem");
		person1.setSurname("Kaya");
		person1.setBirthYear(1990);
		person1.setTc("199992323");
		personList.add(person1);

		for (Person p : personList) {
			if (p.getTc().equals(tc)) {
				p.setName(person.getName());
				p.setSurname(person.getSurname());
				p.setBirthYear(person.getBirthYear());
				p.setTc(person.getTc());
				return ResponseEntity.ok(p);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("person/{tc}")
	public ResponseEntity<Person> deletePerson(@RequestBody Person person, @PathVariable("tc") String tc) { // body olarak aldığımızda veri paket halinde geliyor. bu yüzden requestbody kullanıyoruz.
		List<Person> personList = new ArrayList<>();
		Person person1 = new Person();
		person1.setName("Gizem");
		person1.setSurname("Kaya");
		person1.setBirthYear(1990);
		person1.setTc("199992323");
		personList.add(person1);

		for (Person p : personList) {
			if (p.getTc().equals(tc)) {
				personList.remove(p);
				return ResponseEntity.ok(p);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
