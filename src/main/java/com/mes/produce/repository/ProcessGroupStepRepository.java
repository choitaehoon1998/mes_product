package com.mes.produce.repository;

import com.mes.produce.entity.ProcessGroupStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessGroupStepRepository extends JpaRepository<ProcessGroupStep, Long>, ProcessGroupStepQueryRepository {
}
