package com.delivery.infrastructure.api;

import com.delivery.application.usecase.GetDeliveryModesUseCase;
import com.delivery.domain.model.DeliveryMode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryModeController {
    private final GetDeliveryModesUseCase getDeliveryModesUseCase;

    public DeliveryModeController(GetDeliveryModesUseCase getDeliveryModesUseCase) {
        this.getDeliveryModesUseCase = getDeliveryModesUseCase;
    }

    @GetMapping("/delivery-modes")
    public List<DeliveryMode> getDeliveryModes() {
        return getDeliveryModesUseCase.execute();
    }
}
