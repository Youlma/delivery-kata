package com.delivery.infrastructure.persistence;

import com.delivery.infrastructure.persistence.TimeSlotEntity;
import com.delivery.infrastructure.persistence.JpaTimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TimeSlotRepositoryTest {

    @Autowired
    private JpaTimeSlotRepository repository;

    @Test
    public void testFindAvailableSlots() {
        repository.save(new TimeSlotEntity("1", LocalDateTime.now(), LocalDateTime.now().plusHours(2), false));
        List<TimeSlotEntity> slots = repository.findByStartDateTimeAfterAndReservedFalse(LocalDateTime.now().minusDays(1));
        assertEquals(1, slots.size());
    }
}