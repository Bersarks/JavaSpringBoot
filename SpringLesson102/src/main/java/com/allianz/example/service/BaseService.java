package com.allianz.example.service;

import com.allianz.example.database.entity.BaseEntity;
import com.allianz.example.util.BaseDTO;
import com.allianz.example.util.BaseMapper;
import com.allianz.example.util.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public abstract class BaseService<Entity extends BaseEntity,
        RequestDTO extends BaseDTO,
        ResponseDTO extends BaseDTO> {

    @Autowired
    private IBaseRepository<Entity, Long> repository;

    @Autowired
    private BaseMapper<ResponseDTO, Entity, RequestDTO> baseMapper;

    public List<Entity> getAll() {
        return repository.findAll();
    }

    public void deleteByUUID(UUID uuid) {
        repository.deleteByUuid(uuid);
    }

    public Entity getByUUID(UUID uuid) {
        Optional<Entity> optionalEntity = repository.findByUuid(uuid);
        return optionalEntity.orElse(null);
    }

//    public abstract ResponseDTO updateByUUID(UUID uuid, RequestDTO requestDTO);

    public ResponseDTO save(RequestDTO requestDTO) {
        Entity entity = baseMapper.requestDTOToEntity(requestDTO);

        return baseMapper.entityToDTO(repository.save(entity));
    }

}
