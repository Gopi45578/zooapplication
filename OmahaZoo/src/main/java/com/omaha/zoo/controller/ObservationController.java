package com.omaha.zoo.controller;

import com.omaha.zoo.model.Observation;
import com.omaha.zoo.service.ObservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/observations")
@CrossOrigin(origins = "http://localhost:3000") // React's default port
public class ObservationController {

    private final ObservationService observationService;

    public ObservationController(ObservationService observationService) {
        this.observationService = observationService;
    }

    @GetMapping
    public ResponseEntity<List<Observation>> getAllObservations() {
        return new ResponseEntity<>(
                observationService.getAllObservations(),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Observation> createObservation(@RequestBody Observation observation) {
        return new ResponseEntity<>(
                observationService.createObservation(observation),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/animal/{animalName}")
    public ResponseEntity<List<Observation>> getObservationsByAnimalName(
            @PathVariable String animalName) {
        return new ResponseEntity<>(
                observationService.getObservationsByAnimalName(animalName),
                HttpStatus.OK
        );
    }

    @GetMapping("/behavior/{behavior}")
    public ResponseEntity<List<Observation>> getObservationsByBehavior(
            @PathVariable Observation.Behavior behavior) {
        return new ResponseEntity<>(
                observationService.getObservationsByBehavior(behavior),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObservation(@PathVariable String id) {
        observationService.deleteObservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}