package com.delivery.infrastructure.messaging.consumer;

import com.delivery.domain.event.DeliveryEvent;
import com.delivery.domain.service.DeliveryService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryEventConsumer {

    private final DeliveryService deliveryService;

    public DeliveryEventConsumer(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @KafkaListener(topics = "delivery-events", groupId = "delivery-group")
    public void consume(DeliveryEvent event) {
        System.out.println("Réception de l'événement : " + event.getEventType());

        switch (event.getEventType()) {
            case "RESERVED":
                deliveryService.processReservation(event); 
                break;
            case "DELIVERED":
                deliveryService.processDelivery(event); 
                break;
            default:
                System.out.println("Type d'événement inconnu : " + event.getEventType());
        }
    }
}