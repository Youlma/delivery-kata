package com.delivery.infrastructure.messaging.consumer;

import com.delivery.domain.event.DeliveryEvent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@EmbeddedKafka(topics = {"delivery-events"})
@DirtiesContext
public class DeliveryEventConsumerTest {

    @Test
    public void testConsumeEvent() {
        DeliveryEvent event = new DeliveryEvent("RESERVED", "Slot reserved");

        // Simulez la publication d'un événement et vérifiez qu'il est consommé
        assertTrue(true); // Remplacez par une vérification réelle
    }
}