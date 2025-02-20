package com.delivery.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "time_slots")
public class TimeSlotEntity {

    @Id
    private String id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private boolean reserved;

    // Constructeur sans arguments (nécessaire pour JPA)
    public TimeSlotEntity() {}

    // Constructeur avec arguments
    public TimeSlotEntity(String id, LocalDateTime startDateTime, LocalDateTime endDateTime, boolean reserved) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.reserved = reserved;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}