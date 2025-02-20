package com.delivery.infrastructure.messaging.consumer;

import com.delivery.domain.event.DeliveryEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryEventConsumer {

    @KafkaListener(topics = "delivery-events", groupId = "delivery-group")
    public void consume(DeliveryEvent event) {
        System.out.println("Received delivery event: " + event.getEventType());
        // Traiter l'événement ici (par exemple, mettre à jour un rapport ou notifier un service externe)
    }
}
