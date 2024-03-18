package org.jetbrains.assignment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CoordinateEntity {
    @Id
    @GeneratedValue
    private Long id;


    int x;

    int y;

    public CoordinateEntity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CoordinateEntity() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
