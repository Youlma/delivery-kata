package com.delivery.infrastructure.messaging.producer;

import com.delivery.domain.event.DeliveryEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@EmbeddedKafka(topics = {"delivery-events"})
@DirtiesContext
public class DeliveryEventProducerTest {

    @Autowired
    private DeliveryEventProducer producer;

    @Test
    public void testPublishEvent() {
        DeliveryEvent event = new DeliveryEvent("RESERVED", "Slot reserved");
        producer.publishEvent(event);

        // Vérifiez que l'événement a été publié (utilisez un consommateur mock si nécessaire)
        assertTrue(true); // Remplacez par une vérification réelle
    }
}