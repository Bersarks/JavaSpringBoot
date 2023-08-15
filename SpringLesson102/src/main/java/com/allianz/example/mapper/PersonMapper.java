package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getSurname());
        personDTO.setSurname(entity.getSurname());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setUpdateDate(entity.getUpdateDate());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUuid(entity.getUuid());
        personDTO.setId(entity.getId());

        return personDTO;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setBirthYear(dto.getBirthYear());
        personEntity.setUuid(dto.getUuid());
        personEntity.setId(dto.getId());
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setTc(dto.getTc());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdateDate(dto.getUpdateDate());

        List<AddressEntity> addressEntityList = new ArrayList<>();
        for (AddressDTO addressDTO : dto.getAddressList()) {
            addressEntityList.add(addressMapper.dtoToEntity(addressDTO));
        }

        personEntity.setAddressEntityList(addressEntityList);
        return personEntity;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> personDTOList = new ArrayList<>();

        for (PersonEntity person : personEntities) {
            personDTOList.add(entityToDTO(person));
        }

        return personDTOList;
    }

    @Override
    public List<PersonEntity> dtoListToEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> personEntityList = new ArrayList<>();

        for (PersonDTO personDTO : personDTOS) {
            personEntityList.add(dtoToEntity(personDTO));
        }
        return personEntityList;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity = new PersonEntity();

        personEntity.setId(dto.getId());
        personEntity.setUuid(dto.getUuid());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdateDate(dto.getUpdateDate());
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setTc(dto.getTc());
        personEntity.setBirthYear(dto.getBirthYear());

        return null;
    }
}
