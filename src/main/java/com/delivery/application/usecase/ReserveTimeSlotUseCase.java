package com.delivery.application.usecase;

import com.delivery.domain.model.TimeSlot;
import com.delivery.domain.service.TimeSlotService;

public class ReserveTimeSlotUseCase {
    private final TimeSlotService timeSlotService;

    public ReserveTimeSlotUseCase(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    public void execute(TimeSlot timeSlot) {
        timeSlotService.reserveTimeSlot(timeSlot);
    }
}
