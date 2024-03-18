package org.jetbrains.assignment.repository;

import org.jetbrains.assignment.entities.MoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoveEntityRepository extends JpaRepository<MoveEntity, Long> {
}
