package com.delivery.application.usecase;

import com.delivery.domain.model.DeliveryMode;
import com.delivery.domain.service.DeliveryService;

import java.util.List;

public class GetDeliveryModesUseCase {
    private final DeliveryService deliveryService;

    public GetDeliveryModesUseCase(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public List<DeliveryMode> execute() {
        return deliveryService.getAvailableDeliveryModes();
    }
}