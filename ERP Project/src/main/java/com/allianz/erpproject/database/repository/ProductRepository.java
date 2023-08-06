package com.allianz.erpproject.database.repository;

import com.allianz.erpproject.database.entity.ProductEntity;
import com.allianz.erpproject.util.rputil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<ProductEntity, Long> {
}
