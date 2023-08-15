package com.allianz.springlesson.controller;

import com.allianz.springlesson.model.PersonDTO;
import com.allianz.springlesson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController // bunu reste controller olduğunu bildirmek için bunu koymamız gerekiyor! *****************
@RequestMapping("PersonDTO") // localhost:8080/api üzerinden request atılabilir.
public class PersonController {
	// Endpoint --> bitiş noktası, son nokta. URL yani kullanıcıya verilen adres.
	// localhost:8080/ --> localhost:8080/hello-world.html üzerinden request atılabiliyor.

	@Autowired // Bean olarak bellekte bulunan aynı objeyi kullanıyor. PersonDTOService PersonDTOService = new PersonDTOService(); ile aynı şey.
	PersonService personService;

	@GetMapping("hello-world") // bursaı url deki endpoint
	public ResponseEntity<String> index() { // ResponseEntity veriyi arkada json formatına çevirip kullanıcıya o şekilde gönderir.
		return new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
	}

	@GetMapping("PersonDTO")
	public ResponseEntity<PersonDTO> PersonDTOAPI() {

		PersonDTO PersonDTO = new PersonDTO();
		PersonDTO.setName("Mehmet");
		PersonDTO.setSurname("Kaya");
		PersonDTO.setBirthYear(1990);
		PersonDTO.setTc("199992323");

		return new ResponseEntity<>(PersonDTO, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
	}

	//pathVariable --> url deki değişkenleri almak için kullanılır. localhost:8080/api/PersonDTO/1

	@GetMapping("PersonDTO/{PersonDTOId}")
	public ResponseEntity<List<PersonDTO>> PersonDTOsAPI(@PathVariable("PersonDTOId") int PersonDTOId) { // içerdeki parametrenin adı yukarıda tanımlanan ile aynı olmak zorunda.
		PersonDTO PersonDTO = new PersonDTO();
		PersonDTO.setName("Mehmet");
		PersonDTO.setSurname("Kaya");
		PersonDTO.setBirthYear(1990);
		PersonDTO.setTc("199992323");

		PersonDTO PersonDTO1 = new PersonDTO();
		PersonDTO1.setName("Gizem");
		PersonDTO1.setSurname("Kaya");
		PersonDTO1.setBirthYear(1990);
		PersonDTO1.setTc("199992323");

		List<PersonDTO> PersonDTOList = new ArrayList<>();
		PersonDTOList.add(PersonDTO1);
		PersonDTOList.add(PersonDTO);
		return new ResponseEntity<>(PersonDTOList, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
	}

	@GetMapping("PersonDTO-by-request-param")
	public ResponseEntity<List<PersonDTO>> getPersonDTO(@RequestParam int PersonDTOId, @RequestParam int tc) { // burada urlden gelen parametreleri alıyoruz. ona göre veri gönderimi yapıyoruz.

		System.out.println("PersonDTOId: " + PersonDTOId);
		System.out.println("tc: " + tc);

		PersonDTO PersonDTO = new PersonDTO();
		PersonDTO.setName("Mehmet");
		PersonDTO.setSurname("Kaya");
		PersonDTO.setBirthYear(1990);
		PersonDTO.setTc("199992323");

		PersonDTO PersonDTO1 = new PersonDTO();
		PersonDTO1.setName("Gizem");
		PersonDTO1.setSurname("Kaya");
		PersonDTO1.setBirthYear(1990);
		PersonDTO1.setTc("199992323");

		List<PersonDTO> PersonDTOList = new ArrayList<>();
		PersonDTOList.add(PersonDTO1);
		PersonDTOList.add(PersonDTO);
		//return new ResponseEntity<>(PersonDTOList, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
		return ResponseEntity.ok(PersonDTOList);
	}

	@GetMapping("PersonDTOList-by-name-starting-with/{key}")
	public ResponseEntity<List<PersonDTO>> getPersonDTOList(@PathVariable String key) { // burada urlden gelen parametreleri alıyoruz. ona göre veri gönderimi yapıyoruz.

		//return new ResponseEntity<>(PersonDTOList, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
		return ResponseEntity.ok(personService.getPerson(key));
	}

	@GetMapping("PersonDTOList-by-name-starting-with-or-surname/name/{name}/surname/{surname}")
	public ResponseEntity<List<PersonDTO>> getPersonDTOList(@PathVariable String name, @PathVariable String surname) { // burada urlden gelen parametreleri alıyoruz. ona göre veri gönderimi yapıyoruz.

		//return new ResponseEntity<>(PersonDTOList, HttpStatus.ACCEPTED);
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
		return ResponseEntity.ok(personService.getPersonNameOrSurname(name, surname));
	}

	@GetMapping("PersonDTOList-by-name-contains-with/{key}")
	public ResponseEntity<List<PersonDTO>> getPersonDTOListContainsKey(@PathVariable String key) {
		return ResponseEntity.ok(personService.getPersonIContains(key));
	}

	// direkt olarak objeyi alabiliyoruz bu şekilde. json formatında geliyor. Key value pairleri aynı isim olması en iyi durum.
	// SSL sertifikası varsa o şifrelenmiş bir şekilde veriler ilerler.
	@PostMapping("PersonDTO")
	public ResponseEntity<PersonDTO> createPersonDTO(@RequestBody PersonDTO personDTO) throws Exception { // body olarak aldığımızda veri paket halinde geliyor. bu yüzden requestbody kullanıyoruz.
		PersonDTO PersonDTO1 = personService.createPerson(personDTO.getName(), personDTO.getSurname(),
				personDTO.getBirthYear(), personDTO.getTc());
		//throw new Exception("Hata oluştu");
		return ResponseEntity.ok(PersonDTO1);
	}


	//PathVariable ile url den direkt veriyi alıyoruz
	// RequestParam ile ?tc=asdasd gibi bir atama yapılması gerekiyor.
	@PutMapping("PersonDTO/{tc}")
	public ResponseEntity<PersonDTO> searchPersonDTO(@RequestBody PersonDTO PersonDTO, @PathVariable("tc") String tc) { // body olarak aldığımızda veri paket halinde geliyor. bu yüzden requestbody kullanıyoruz.
		List<PersonDTO> PersonDTOList = new ArrayList<>();
		PersonDTO PersonDTO1 = new PersonDTO();
		PersonDTO1.setName("Gizem");
		PersonDTO1.setSurname("Kaya");
		PersonDTO1.setBirthYear(1990);
		PersonDTO1.setTc("199992323");
		PersonDTOList.add(PersonDTO1);

		for (PersonDTO p : PersonDTOList) {
			if (p.getTc().equals(tc)) {
				p.setName(PersonDTO.getName());
				p.setSurname(PersonDTO.getSurname());
				p.setBirthYear(PersonDTO.getBirthYear());
				p.setTc(PersonDTO.getTc());
				return ResponseEntity.ok(p);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("PersonDTO/{uuid}")
	public ResponseEntity<Boolean> deletePersonDTO(@RequestBody PersonDTO PersonDTO, @PathVariable("uuid") UUID uuid) { // body olarak aldığımızda veri paket halinde geliyor. bu yüzden requestbody kullanıyoruz.
		boolean isDeleted = personService.deletePersonDTOByUUID(uuid);
		if (isDeleted) {
			return ResponseEntity.ok(isDeleted);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("PersonDTO-by-uuid/{uuid}")
	public ResponseEntity<PersonDTO> getPersonDTOByUUID(@PathVariable UUID uuid) {
		PersonDTO PersonDTOEntity = personService.getPersonByUUID(uuid);
		if (PersonDTOEntity != null) {
			return new ResponseEntity<>(PersonDTOEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("PersonDTO-update/{uuid}")
	public ResponseEntity<PersonDTO> updatePersonDTOByUUID(@PathVariable UUID uuid,
														   @RequestBody PersonDTO newPersonDTO) {

		PersonDTO PersonDTO = personService.updatePersonByUUID(uuid, newPersonDTO);

		if (PersonDTO != null) {
			return new ResponseEntity<>(PersonDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	// MVP minimum viable product
}
