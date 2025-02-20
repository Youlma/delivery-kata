package com.delivery.infrastructure.messaging.producer;

import com.delivery.application.port.EventPublisher;
import com.delivery.domain.event.DeliveryEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeliveryEventProducer implements EventPublisher {
    private final KafkaTemplate<String, DeliveryEvent> kafkaTemplate;

    public DeliveryEventProducer(KafkaTemplate<String, DeliveryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    @Override
    public void publishEvent(Object event) {
        kafkaTemplate.send("delivery-events", (DeliveryEvent) event);
    }
}
