package com.delivery.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.delivery.domain.model.DeliveryMode;

@Entity
@Table(name = "time_slots")
public class TimeSlotEntity {

    @Id
    private String id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private boolean reserved;
    private DeliveryMode delivered;

    public TimeSlotEntity() {}

    public TimeSlotEntity(String id, LocalDateTime startDateTime, LocalDateTime endDateTime, boolean reserved) {
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.reserved = reserved;
    }

    public TimeSlotEntity(LocalDate now, LocalTime of, LocalTime of2, DeliveryMode delivery) {
    	this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.delivered = delivery;
	}

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

	public DeliveryMode getDelivered() {
		return delivered;
	}

	public void setDelivered(DeliveryMode delivered) {
		this.delivered = delivered;
	}
    
    
}