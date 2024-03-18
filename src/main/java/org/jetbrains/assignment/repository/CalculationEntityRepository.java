package org.jetbrains.assignment.repository;

import org.jetbrains.assignment.entities.CalculationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationEntityRepository extends JpaRepository<CalculationEntity, Long> {
}
