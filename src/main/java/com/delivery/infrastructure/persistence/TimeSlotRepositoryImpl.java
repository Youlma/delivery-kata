package com.delivery.infrastructure.persistence;

import com.delivery.application.port.TimeSlotRepository;
import com.delivery.domain.model.TimeSlot;
import com.delivery.infrastructure.persistence.TimeSlotEntity;
import com.delivery.infrastructure.persistence.TimeSlotMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    
    @Override
    public void reserveTimeSlot(String slotId) {
        Optional<TimeSlotEntity> optionalEntity = jpaRepository.findById(slotId);
        if (optionalEntity.isPresent()) {
            TimeSlotEntity entity = optionalEntity.get();
            entity.setReserved(true); // Marquer comme réservé
            jpaRepository.save(entity);
        } else {
            System.out.println("Créneau non trouvé pour l'ID : " + slotId);
        }
    }

    @Override
    public void markAsDelivered(String slotId) {
        Optional<TimeSlotEntity> optionalEntity = jpaRepository.findById(slotId);
        if (optionalEntity.isPresent()) {
            TimeSlotEntity entity = optionalEntity.get();
            entity.setReserved(true); 
            jpaRepository.save(entity);
        } else {
            System.out.println("Créneau non trouvé pour l'ID : " + slotId);
        }
    }

    @Override
    public TimeSlot findById(String slotId) {
        return jpaRepository.findById(slotId)
                .map(TimeSlotMapper::toDomain)
                .orElse(null);
    }
}