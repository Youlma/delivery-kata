package com.delivery.infrastructure.messaging.consumer;

import com.delivery.domain.event.DeliveryEvent;
import com.delivery.domain.service.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class DeliveryEventConsumerTest {

    @MockBean
    private DeliveryService deliveryService;

    @Autowired
    private DeliveryEventConsumer consumer;

    @BeforeEach
    void setUp() {
        Mockito.reset(deliveryService);
    }

    @Test
    void testConsumeDeliveryEvent() {
        DeliveryEvent event = new DeliveryEvent("DELIVERED", "slotId");
        consumer.consume(event);

        Mockito.verify(deliveryService).processDelivery(event);
    }

    @Test
    void testConsumeReservationEvent() {
        DeliveryEvent event = new DeliveryEvent("RESERVED", "slotId");
        consumer.consume(event);

        Mockito.verify(deliveryService).processReservation(event);
    }
}