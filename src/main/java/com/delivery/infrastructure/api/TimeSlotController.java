package com.delivery.infrastructure.api;

import com.delivery.application.usecase.ReserveTimeSlotUseCase;
import com.delivery.domain.model.TimeSlot;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/time-slots")
public class TimeSlotController {
    private final ReserveTimeSlotUseCase reserveTimeSlotUseCase;

    public TimeSlotController(ReserveTimeSlotUseCase reserveTimeSlotUseCase) {
        this.reserveTimeSlotUseCase = reserveTimeSlotUseCase;
    }

    @PostMapping("/reserve")
    public void reserveTimeSlot(@RequestBody TimeSlot timeSlot) {
        reserveTimeSlotUseCase.execute(timeSlot);
    }
}
