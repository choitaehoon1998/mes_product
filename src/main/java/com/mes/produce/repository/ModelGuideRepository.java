package com.mes.produce.repository;

import com.mes.produce.entity.ModelGuide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelGuideRepository extends JpaRepository<ModelGuide,Long> ,ModelGuideQueryRepository {
}
