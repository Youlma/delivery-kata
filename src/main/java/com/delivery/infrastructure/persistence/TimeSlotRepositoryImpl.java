package com.delivery.infrastructure.persistence;

import com.delivery.application.port.TimeSlotRepository;
import com.delivery.domain.model.TimeSlot;
import com.delivery.infrastructure.persistence.TimeSlotEntity;
import com.delivery.infrastructure.persistence.TimeSlotMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TimeSlotRepositoryImpl implements TimeSlotRepository {

    private final JpaTimeSlotRepository jpaRepository;

    public TimeSlotRepositoryImpl(JpaTimeSlotRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<TimeSlot> findAvailableSlots(LocalDateTime date) {
        return jpaRepository.findByStartDateTimeAfterAndReservedFalse(date)
                .stream()
                .map(TimeSlotMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void save(TimeSlot timeSlot) {
        jpaRepository.save(TimeSlotMapper.toEntity(timeSlot));
    }
}