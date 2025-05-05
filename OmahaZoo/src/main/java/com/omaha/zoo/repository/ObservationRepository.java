package com.omaha.zoo.repository;

import com.omaha.zoo.model.Observation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObservationRepository extends MongoRepository<Observation, String> {

    // Custom query to get all observations sorted by timestamp descending
    @Query(value = "{}", sort = "{ 'timestamp' : -1 }")
    List<Observation> findAllByOrderByTimestampDesc();

    // Additional custom queries can be added here
    List<Observation> findByAnimalName(String animalName);
    List<Observation> findByBehavior(Observation.Behavior behavior);
}