package org.jetbrains.assignment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.jetbrains.assignment.model.Direction;

@Entity
public class MoveEntity {

    @Id
    @GeneratedValue
    private Long id;

    Direction direction;

    int steps;

    public MoveEntity(Direction direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public MoveEntity() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
