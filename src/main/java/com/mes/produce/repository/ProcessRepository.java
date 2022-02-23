package com.mes.produce.repository;

import com.mes.produce.entity.Process;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessRepository extends JpaRepository<Process, Long>, ProcessQueryRepository {
}
