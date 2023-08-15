package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AddressEntityRepository extends IBaseRepository<AddressEntity, Long> {

    List<AddressEntity> getAddressEntitiesByAddressIsContaining(String key);

}
