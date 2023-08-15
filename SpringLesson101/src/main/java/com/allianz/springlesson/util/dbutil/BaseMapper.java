package com.allianz.springlesson.util.dbutil;

import com.allianz.springlesson.util.BaseDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BaseMapper<DTO extends BaseDTO, ENTITY extends BaseEntity, REQUESTDTO extends BaseDTO>{

	public ENTITY dtoToEntity(DTO dto) {
		ENTITY entity = (ENTITY) new Object();
		BeanUtils.copyProperties(entity, dto);
		return entity;
	}
	public DTO entityToDTO(ENTITY entity) {
		DTO dto = (DTO) new Object();
		BeanUtils.copyProperties(dto, entity);
		return dto;
	}
	public List<DTO> entityListToDTOList(List<ENTITY> personEntities) {
		List<DTO> dtoList = (List<DTO>) new Object();
		for (ENTITY entity : personEntities) {
			dtoList.add(entityToDTO(entity));
		}
		return dtoList;
	}

	public List<ENTITY> dtoListToEntityList(List<DTO> dtos) {
		List<ENTITY> entityList = (List<ENTITY>) new Object();
		for (DTO dto : dtos) {
			entityList.add(dtoToEntity(dto));
		}
		return entityList;
	}

	public ENTITY requestDTOToEntity(REQUESTDTO dto) {
		ENTITY entity = (ENTITY) new Object();
		BeanUtils.copyProperties(entity, dto);
		return entity;
	}
}
