package com.mes.produce.repository;

import com.mes.produce.entity.ProcessGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessGroupRepository extends JpaRepository<ProcessGroup, Long>, ProcessGroupQueryRepository {
}
