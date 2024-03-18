package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.Coordinate;
import org.jetbrains.assignment.model.Direction;
import org.jetbrains.assignment.model.Move;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class MovementService {

    public List<Coordinate> calculateCoordinates(List<Move> moves){
        Coordinate start = new Coordinate(0, 0);

        LinkedList<Coordinate> steps = new LinkedList<>();
        steps.add(start);

        Coordinate currentPosition = start;

        for(Move move: moves){
            int deltaX = move.direction().getX() * move.steps();
            int deltaY = move.direction().getY() * move.steps();
            Coordinate nextPlace = new Coordinate(currentPosition.x() + deltaX, currentPosition.y() + deltaY);
            steps.add(nextPlace);
            currentPosition = nextPlace;
        }

        return steps;
    }

    public List<Move> calculateMoves(List<Coordinate> coordinates){

        LinkedList<Move> moves = new LinkedList<>();

        if(coordinates.size() < 2){
            return Collections.emptyList();
        }

        Coordinate current = coordinates.get(0);

        for(int i = 1; i < coordinates.size(); i++){
            Coordinate coordinate = coordinates.get(i);
            int deltaX = coordinate.x() - current.x();
            int deltaY = coordinate.y() - current.y();

            Direction direction = findDirection(deltaX, deltaY);

            int tmp = Math.max(Math.abs(deltaX),Math.abs(deltaY));
            moves.add(new Move(direction, tmp));
            current = coordinate;
        }

        return moves;
    }

    private Direction findDirection(int deltaX, int deltaY){
        Direction direction;

        if (deltaX > 0) {
            direction = Direction.EAST;
        } else if (deltaX < 0){
            direction = Direction.WEST;
        } else if (deltaY > 0) {
            direction = Direction.NORTH;
        } else if (deltaY < 0) {
            direction = Direction.SOUTH;
        } else {
            // TODO how to handle no move?
            throw new IllegalArgumentException("There was no move");
        }

        return direction;
    }

}
