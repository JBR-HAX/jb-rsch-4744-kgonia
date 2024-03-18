package org.jetbrains.assignment.controller;


import org.jetbrains.assignment.model.Coordinate;
import org.jetbrains.assignment.model.Move;
import org.jetbrains.assignment.service.DbService;
import org.jetbrains.assignment.service.MovementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationsController {

    private final MovementService movementService;
    private final DbService dbService;

    public LocationsController(MovementService movementService, DbService dbService) {
        this.movementService = movementService;
        this.dbService = dbService;
    }

    @PostMapping("/locations")
    public List<Coordinate> calculateCoordinates(@RequestBody List<Move> directions){
        List<Coordinate> coordinates = movementService.calculateCoordinates(directions);

        dbService.save(directions, coordinates);

        return coordinates;
    }

    @PostMapping("/moves")
    public List<Move> calculateMoves(@RequestBody List<Coordinate> coordinates){
        List<Move> moves = movementService.calculateMoves(coordinates);

        dbService.save(moves, coordinates);
        return moves;
    }
}
