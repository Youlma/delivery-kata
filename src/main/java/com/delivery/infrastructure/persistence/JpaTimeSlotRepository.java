package com.delivery.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.infrastructure.persistence.TimeSlotEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaTimeSlotRepository extends JpaRepository<TimeSlotEntity, String> {
    List<TimeSlotEntity> findByStartDateTimeAfterAndReservedFalse(LocalDateTime date);
}
