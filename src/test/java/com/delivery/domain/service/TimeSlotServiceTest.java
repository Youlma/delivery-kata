package com.delivery.domain.service;

import com.delivery.application.port.TimeSlotRepository;
import com.delivery.domain.model.TimeSlot;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TimeSlotServiceTest {

    @Test
    public void testGetAvailableTimeSlots() {
        TimeSlotRepository mockRepository = Mockito.mock(TimeSlotRepository.class);
        LocalDateTime date = LocalDateTime.now();
        when(mockRepository.findAvailableSlots(date)).thenReturn(Collections.emptyList());

        TimeSlotService service = new TimeSlotService(mockRepository);
        assertEquals(0, service.getAvailableTimeSlots(date).size());
    }
}
