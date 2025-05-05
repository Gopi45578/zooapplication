package com.omaha.zoo.service;

import com.omaha.zoo.model.Observation;
import com.omaha.zoo.repository.ObservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    private final ObservationRepository observationRepository;

    public ObservationService(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public List<Observation> getAllObservations() {
        return observationRepository.findAllByOrderByTimestampDesc();
    }

    public Observation createObservation(Observation observation) {
        return observationRepository.save(observation);
    }

    public List<Observation> getObservationsByAnimalName(String animalName) {
        return observationRepository.findByAnimalName(animalName);
    }

    public List<Observation> getObservationsByBehavior(Observation.Behavior behavior) {
        return observationRepository.findByBehavior(behavior);
    }

    public void deleteObservation(String id) {
        observationRepository.deleteById(id);
    }
}