package com.delivery.infrastructure.persistence;

import com.delivery.domain.model.TimeSlot;
import com.delivery.infrastructure.persistence.TimeSlotEntity;
import java.time.LocalDateTime;

public class TimeSlotMapper {

    public static TimeSlot toDomain(TimeSlotEntity entity) {
        return new TimeSlot(entity.getStartDateTime(), entity.getEndDateTime());
    }

    public static TimeSlotEntity toEntity(TimeSlot timeSlot) {
        TimeSlotEntity entity = new TimeSlotEntity();
        entity.setStartDateTime(timeSlot.getStartDateTime());
        entity.setEndDateTime(timeSlot.getEndDateTime());
        return entity;
    }
}