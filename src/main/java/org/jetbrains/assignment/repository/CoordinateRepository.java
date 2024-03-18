package org.jetbrains.assignment.repository;

import org.jetbrains.assignment.entities.CoordinateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CoordinateRepository extends JpaRepository<CoordinateEntity, Long> {
}
