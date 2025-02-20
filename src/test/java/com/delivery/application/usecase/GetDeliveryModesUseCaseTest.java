package com.delivery.application.usecase;

import com.delivery.domain.model.DeliveryMode;
import com.delivery.domain.service.DeliveryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDeliveryModesUseCaseTest {
    @Test
    public void testGetDeliveryModes() {
        DeliveryService mockService = Mockito.mock(DeliveryService.class);
        Mockito.when(mockService.getAvailableDeliveryModes()).thenReturn(Arrays.asList(
                DeliveryMode.DRIVE,
                DeliveryMode.DELIVERY
        ));

        GetDeliveryModesUseCase useCase = new GetDeliveryModesUseCase(mockService);
        List<DeliveryMode> result = useCase.execute();

        assertEquals(2, result.size());
        assertEquals(DeliveryMode.DRIVE, result.get(0));
    }
}