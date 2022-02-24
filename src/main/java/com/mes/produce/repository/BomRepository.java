package com.mes.produce.repository;

import com.mes.produce.entity.Bom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface BomRepository extends JpaRepository<Bom,Long> ,BomQueryRepository {
}
