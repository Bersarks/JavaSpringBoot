package com.allianz.springlesson.mapper;

import com.allianz.springlesson.database.entitiy.AddressEntity;
import com.allianz.springlesson.model.AddressDTO;
import com.allianz.springlesson.model.requestDTO.AddressReuquestDTO;
import com.allianz.springlesson.util.IBaseMapper;
import com.allianz.springlesson.util.dbutil.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //service anotsayonuna benzer bean oluşturuyor ve spring context'e ekliyor. bunu her yerden çağırabiliyoruz. StreoType anotasyonlarından biri.
public class AddressMapper implements IBaseMapper<AddressDTO, AddressEntity, AddressReuquestDTO> {
	@Override
	public AddressDTO entityToDTO(AddressEntity entity) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(entity.getId());
		addressDTO.setUuid(entity.getUuid());
		addressDTO.setCreatedDate(entity.getCreatedDate());
		addressDTO.setUpdatedDate(entity.getUpdatedDate());
		addressDTO.setTitle(entity.getTitle());
		addressDTO.setAddress(entity.getAddress());
		return addressDTO;
	}

	@Override
	public AddressEntity dtoToEntity(AddressDTO dto) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId(dto.getId());
		addressEntity.setUuid(dto.getUuid());
		addressEntity.setCreatedDate(dto.getCreatedDate());
		addressEntity.setUpdatedDate(dto.getUpdatedDate());
		addressEntity.setTitle(dto.getTitle());
		addressEntity.setAddress(dto.getAddress());
		return addressEntity;
	}

	@Override
	public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
		List<AddressDTO> addressDTOList = new ArrayList<>();
		for (AddressEntity addressEntity : addressEntities) {
				addressDTOList.add(entityToDTO(addressEntity));
			}
		return addressDTOList;
	}

	@Override
	public List<AddressEntity> dtoListToEntityList(List<AddressDTO> addressDTOS) {
		List<AddressEntity> addressList = new ArrayList<>();
		for (AddressDTO addressEntity : addressDTOS) {
			addressList.add(dtoToEntity(addressEntity));
		}
		return addressList;
	}

	@Override
	public AddressEntity requestDTOToEntity(AddressReuquestDTO dto) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setTitle(dto.getTitle());
		addressEntity.setAddress(dto.getAddress());
		addressEntity.setUuid(dto.getUuid());
		addressEntity.setId(dto.getId());
		addressEntity.setCreatedDate(dto.getCreatedDate());
		addressEntity.setUpdatedDate(dto.getUpdatedDate());
		return addressEntity;
	}
}
