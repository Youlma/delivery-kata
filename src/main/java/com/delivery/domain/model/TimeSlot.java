package com.delivery.domain.model;

import java.time.LocalDateTime;

public class TimeSlot {
    private final LocalDateTime startDateTime;
    private final LocalDateTime endDateTime;

    public TimeSlot(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }
}