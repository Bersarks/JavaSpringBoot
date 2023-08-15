package com.allianz.springlesson.mapper;

import com.allianz.springlesson.database.entitiy.PersonEntity;
import com.allianz.springlesson.model.PersonDTO;
import com.allianz.springlesson.model.requestDTO.PersonRequestDTO;
import com.allianz.springlesson.service.AddressService;
import com.allianz.springlesson.service.PersonService;
import com.allianz.springlesson.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {
	@Autowired
	private AddressService addressService;
	@Autowired
	private PersonService personService;

	@Override
	public PersonDTO entityToDTO(PersonEntity entity) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(entity.getId());
		personDTO.setUuid(entity.getUuid());
		personDTO.setCreatedDate(entity.getCreatedDate());
		personDTO.setUpdatedDate(entity.getUpdatedDate());
		personDTO.setName(entity.getName());
		personDTO.setSurname(entity.getSurname());
		personDTO.setBirthYear(entity.getBirthYear());
		personDTO.setTc(entity.getTc());
		personDTO.setAddress(addressService.getAddressByPersonId(entity.getId()));

		return null;
	}

	@Override
	public PersonEntity dtoToEntity(PersonDTO dto) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setId(dto.getId());
		personEntity.setUuid(dto.getUuid());
		personEntity.setCreatedDate(dto.getCreatedDate());
		personEntity.setUpdatedDate(dto.getUpdatedDate());
		personEntity.setName(dto.getName());
		personEntity.setSurname(dto.getSurname());
		personEntity.setBirthYear(dto.getBirthYear());
		personEntity.setTc(dto.getTc());
		personEntity.setAddressEntityList(dtoListToEntityList(addressService.getAddressByPersonId(dto.getId())));
		return null;
	}

	@Override
	public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
		return null;
	}

	@Override
	public List<PersonEntity> dtoListToEntityList(List<PersonDTO> personDTOS) {
		return null;
	}

	@Override
	public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
		return null;
	}
}
