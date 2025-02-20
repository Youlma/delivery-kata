package com.delivery.domain.service;

import com.delivery.domain.event.DeliveryEvent;
import com.delivery.domain.model.DeliveryMode;

import java.util.List;

public interface DeliveryService {
    List<DeliveryMode> getAvailableDeliveryModes();
    void processReservation(DeliveryEvent event);
    void processDelivery(DeliveryEvent event);
}
