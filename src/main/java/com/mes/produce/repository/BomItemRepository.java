package com.mes.produce.repository;

import com.mes.produce.entity.BomItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BomItemRepository extends JpaRepository<BomItem,Long> , BomItemQueryRepository {
}
