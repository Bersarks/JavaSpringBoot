package com.allianz.springlesson.database.repository;

import com.allianz.springlesson.database.entitiy.AddressEntity;
import com.allianz.springlesson.util.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressEntityRepository extends BaseRepository<AddressEntity, Long> {
	List<AddressEntity> getAllByPersonId(Long id);

}
