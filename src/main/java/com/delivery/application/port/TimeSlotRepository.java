package com.delivery.application.port;

import com.delivery.domain.model.TimeSlot;

import java.time.LocalDateTime;
import java.util.List;

public interface TimeSlotRepository {
    List<TimeSlot> findAvailableSlots(LocalDateTime date);
    void save(TimeSlot timeSlot);
}