package org.jetbrains.assignment.service;

import org.jetbrains.assignment.model.Coordinate;
import org.jetbrains.assignment.model.Direction;
import org.jetbrains.assignment.model.Move;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MovementServiceTest {

    private final MovementService movementService = new MovementService();

    @Test
    void shouldReturnInitialLocationWhenNoMovesProvided() {

        // when
        List<Coordinate> result = movementService.calculateCoordinates(Collections.emptyList());


        // then
        assertThat(result)
                .hasSize(1)
                .contains(new Coordinate(0, 0));
    }

    @Test
    void shouldReturnCoordinatesBasedOnMoves() {
        // given
        List<Move> moves = List.of(new Move(Direction.EAST, 1),
                new Move(Direction.NORTH, 3),
                new Move(Direction.EAST, 3),
                new Move(Direction.SOUTH, 5),
                new Move(Direction.WEST, 2)
        );

        //when
        List<Coordinate> result = movementService.calculateCoordinates(moves);

        // then
        assertThat(result)
                .hasSize(6)
                .containsExactly(
                        new Coordinate(0, 0),
                        new Coordinate(1, 0),
                        new Coordinate(1, 3),
                        new Coordinate(4, 3),
                        new Coordinate(4, -2),
                        new Coordinate(2, -2)
                );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void shouldReturnMovesBasedOnCoordinates(List<Coordinate> coordinates, List<Move> moves) {

        // when
        List<Move> result = movementService.calculateMoves(coordinates);


        assertThat(result)
                .containsSequence(
                        moves
                );
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(
                        new Coordinate(0, 0),
                        new Coordinate(1, 0),
                        new Coordinate(1, 3),
                        new Coordinate(4, 3),
                        new Coordinate(4, -2),
                        new Coordinate(2, -2)
                ), List.of(
                        new Move(Direction.EAST, 1),
                        new Move(Direction.NORTH, 3),
                        new Move(Direction.EAST, 3),
                        new Move(Direction.SOUTH, 5),
                        new Move(Direction.WEST, 2)
                )),
                Arguments.of(List.of(
                        new Coordinate(0, 0),
                        new Coordinate(1, 0),
                        new Coordinate(1, 3),
                        new Coordinate(0, 3),
                        new Coordinate(0, 0)
                ), List.of(
                        new Move(Direction.EAST, 1),
                        new Move(Direction.NORTH, 3),
                        new Move(Direction.WEST, 1),
                        new Move(Direction.SOUTH, 3)
                ))
        );
    }
}
