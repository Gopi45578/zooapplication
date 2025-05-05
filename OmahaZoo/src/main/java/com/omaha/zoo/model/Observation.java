package com.omaha.zoo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "observations") // This is MongoDB's equivalent to @Entity
public class Observation {

    @Id // MongoDB's ID annotation (not javax.persistence.Id)
    private String id; // Note: String type for MongoDB IDs

    private String animalName;
    private Behavior behavior;
    private LocalDateTime timestamp = LocalDateTime.now();

    // Enum definition
    public enum Behavior {
        FEEDING, RESTING, ACTIVE
    }

    // Constructors
    public Observation() {}

    public Observation(String animalName, Behavior behavior) {
        this.animalName = animalName;
        this.behavior = behavior;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Optional: toString() method
    @Override
    public String toString() {
        return "Observation{" +
                "id='" + id + '\'' +
                ", animalName='" + animalName + '\'' +
                ", behavior=" + behavior +
                ", timestamp=" + timestamp +
                '}';
    }
}