package org.jetbrains.assignment.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CalculationEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<MoveEntity> moves;

    @OneToMany
    private List<CoordinateEntity> coordinates;

    public CalculationEntity(List<MoveEntity> moves, List<CoordinateEntity> coordinates) {
        this.moves = moves;
        this.coordinates = coordinates;
    }

    public CalculationEntity() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
