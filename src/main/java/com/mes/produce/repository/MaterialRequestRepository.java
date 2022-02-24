package com.mes.produce.repository;

import com.mes.produce.entity.MaterialRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRequestRepository extends JpaRepository<MaterialRequest,Long> ,MaterialRequestQueryRepository {
}
