package com.delivery.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TimeSlotTest {

    @Test
    public void testValidTimeSlot() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusHours(2);
        TimeSlot timeSlot = new TimeSlot(start, end);

        assertEquals(start, timeSlot.getStartDateTime());
        assertEquals(end, timeSlot.getEndDateTime());
    }

    @Test
    public void testInvalidTimeSlot() {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.minusHours(1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new TimeSlot(start, end));
        assertEquals("La date de début doit précéder la date de fin.", exception.getMessage());
    }
}