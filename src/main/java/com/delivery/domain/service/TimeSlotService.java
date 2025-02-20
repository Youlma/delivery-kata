package com.delivery.domain.service;

import com.delivery.application.port.TimeSlotRepository;
import com.delivery.domain.model.TimeSlot;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @Transactional(readOnly = true)
    public List<TimeSlot> getAvailableTimeSlots(LocalDateTime date) {
        return timeSlotRepository.findAvailableSlots(date);
    }

    @Transactional
    public void reserveTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
    }
}