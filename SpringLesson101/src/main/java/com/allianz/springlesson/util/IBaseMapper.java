package com.allianz.springlesson.util;

import com.allianz.springlesson.util.dbutil.BaseEntity;

import java.util.List;

public interface IBaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {
	DTO entityToDTO(Entity entity);
	Entity dtoToEntity(DTO dto);

	List<DTO> entityListToDTOList(List<Entity> entityList);
	List<Entity> dtoListToEntityList(List<DTO> dtoList);

	Entity requestDTOToEntity(RequestDTO dto);
}
