package org.jetbrains.assignment.service;

import org.jetbrains.assignment.entities.CalculationEntity;
import org.jetbrains.assignment.entities.CoordinateEntity;
import org.jetbrains.assignment.entities.MoveEntity;
import org.jetbrains.assignment.model.Coordinate;
import org.jetbrains.assignment.model.Move;
import org.jetbrains.assignment.repository.CalculationEntityRepository;
import org.jetbrains.assignment.repository.CoordinateRepository;
import org.jetbrains.assignment.repository.MoveEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DbService {

    private final CoordinateRepository coordinateRepository;

    private final MoveEntityRepository moveEntityRepository;

    private final CalculationEntityRepository calculationEntityRepository;


    public DbService(CoordinateRepository coordinateRepository, MoveEntityRepository moveEntityRepository, CalculationEntityRepository calculationEntityRepository) {
        this.coordinateRepository = coordinateRepository;
        this.moveEntityRepository = moveEntityRepository;
        this.calculationEntityRepository = calculationEntityRepository;
    }

    @Transactional
    public void save(List<Move> moves, List<Coordinate> coordinates){
        List<MoveEntity> moveEntities = moves.stream()
                .map(move -> new MoveEntity(move.direction(), move.steps()))
                .toList();

        List<CoordinateEntity> coordinateEntities = coordinates.stream()
                .map(coordinate -> new CoordinateEntity(coordinate.x(), coordinate.y()))
                .toList();

        moveEntityRepository.saveAll(moveEntities);
        coordinateRepository.saveAll(coordinateEntities);

        calculationEntityRepository.save(new CalculationEntity(moveEntities, coordinateEntities));
    }

}
