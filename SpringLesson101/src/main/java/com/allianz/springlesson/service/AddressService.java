package com.allianz.springlesson.service;

import com.allianz.springlesson.database.entitiy.AddressEntity;
import com.allianz.springlesson.database.repository.AddressEntityRepository;
import com.allianz.springlesson.mapper.AddressMapper;
import com.allianz.springlesson.model.AddressDTO;
import com.allianz.springlesson.model.requestDTO.AddressReuquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private AddressEntityRepository addressEntityRepository;

	public AddressDTO saveAddress(AddressReuquestDTO DTO) {
		AddressEntity addressEntity = addressMapper.requestDTOToEntity(DTO);
		addressEntityRepository.save(addressEntity);
		return addressMapper.entityToDTO(addressEntity);
	}

	public List<AddressDTO> getAllAddress() {
		List<AddressEntity> addressEntities = addressEntityRepository.findAll();
		return addressMapper.entityListToDTOList(addressEntities);
	}

	public AddressDTO getAddressByUuid(UUID id) {
		Optional<AddressEntity> addressEntity = addressEntityRepository.findByUuid(id);
		return addressEntity.map(entity -> addressMapper.entityToDTO(entity)).orElse(null);
	}

	public List<AddressDTO> getAddressByPersonId(Long id) {
		List<AddressEntity> addressEntity = addressEntityRepository.getAllByPersonId(id);
		return addressMapper.entityListToDTOList(addressEntity);
	}
}
