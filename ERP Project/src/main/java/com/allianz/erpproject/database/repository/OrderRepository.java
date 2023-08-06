package com.allianz.erpproject.database.repository;

import com.allianz.erpproject.database.entity.OrderEntity;
import com.allianz.erpproject.database.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
	OrderEntity findByUuid(UUID uuid);
	void deleteByUuid(UUID uuid);
}
