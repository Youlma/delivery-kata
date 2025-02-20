package com.delivery.infrastructure.persistence;

import com.delivery.domain.model.DeliveryMode;
import com.delivery.domain.model.TimeSlot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class JpaTimeSlotRepositoryTest {

    @Autowired
    private JpaTimeSlotRepository repository;
    
    @Autowired
    private TimeSlotMapper mapper;

    @Test
    public void testSaveAndFindTimeSlot() {
    	TimeSlotEntity timeSlotEntity = new TimeSlotEntity(
            LocalDate.now(),
            LocalTime.of(10, 0),
            LocalTime.of(11, 0),
            DeliveryMode.DELIVERY
        );

        repository.save(timeSlotEntity);
        Optional<TimeSlotEntity> found = repository.findById(timeSlotEntity.getId());
        assertTrue(found.isPresent(), "Le créneau horaire doit être trouvé");
        
        TimeSlot foundTimeSlot = mapper.toDomain(found.get());
        assertTrue(foundTimeSlot.getStartDateTime().equals(timeSlotEntity.getStartDateTime()), "Les heures de début doivent correspondre");
        assertTrue(foundTimeSlot.getEndDateTime().equals(timeSlotEntity.getEndDateTime()), "Les heures de fin doivent correspondre");

    }
}