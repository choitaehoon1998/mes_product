package com.mes.produce.repository;

import com.mes.produce.entity.MaterialRequestItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRequestItemRepository extends JpaRepository<MaterialRequestItem,Long> , MaterialRequestItemQueryRepository {
}
