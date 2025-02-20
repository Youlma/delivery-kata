package com.delivery.application.port;

public interface EventPublisher {
    void publishEvent(Object event);
}