package com.mes.produce.repository;

import com.mes.produce.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> ,ModelQueryRepository {
}
