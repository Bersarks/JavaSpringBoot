package com.allianz.erpproject.database.repository;

import com.allianz.erpproject.database.entity.ReceiptEntity;
import com.allianz.erpproject.util.rputil.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends BaseRepository<ReceiptEntity, Long> {
}
