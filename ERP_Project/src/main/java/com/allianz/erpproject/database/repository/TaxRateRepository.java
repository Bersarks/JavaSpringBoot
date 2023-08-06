package com.allianz.erpproject.database.repository;

import com.allianz.erpproject.database.entity.TaxRateEntity;
import com.allianz.erpproject.util.rputil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRateRepository extends BaseRepository<TaxRateEntity, Long> {
	TaxRateEntity findByName(String name);
}
