package com.allianz.erpproject.database.repository;

import com.allianz.erpproject.database.entity.CustomerEntity;
import com.allianz.erpproject.database.entity.OrderEntity;
import com.allianz.erpproject.util.rputil.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerEntity, Long> {

	List<CustomerEntity> findAllByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(String name, String surname);
}
