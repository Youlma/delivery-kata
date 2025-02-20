package com.delivery.domain.event;

import lombok.Data;

@Data
public class DeliveryEvent {
    private final String eventType;
    private final Object data;

    public DeliveryEvent(String eventType, Object data) {
        this.eventType = eventType;
        this.data = data;
    }

	public String getEventType() {
		return eventType;
	}

	public Object getData() {
		return data;
	}
    
}
