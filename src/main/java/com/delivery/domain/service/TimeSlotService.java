package com.delivery.domain.service;

import com.delivery.application.port.TimeSlotRepository;
import com.delivery.domain.event.DeliveryEvent;
import com.delivery.domain.model.DeliveryMode;
import com.delivery.domain.model.TimeSlot;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeSlotService implements DeliveryService{
    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
    }

    @Transactional(readOnly = true)
    public List<TimeSlot> getAvailableTimeSlots(LocalDateTime date) {
        return timeSlotRepository.findAvailableSlots(date);
    }

    @Transactional
    public void reserveTimeSlot(TimeSlot timeSlot) {
        timeSlotRepository.save(timeSlot);
    }

	@Override
	public List<DeliveryMode> getAvailableDeliveryModes() {
		return null;
	}

	@Override
    public void processReservation(DeliveryEvent event) {
        System.out.println("Traitement de la réservation : " + event.getData());

        String slotId = (String) event.getData();
        timeSlotRepository.reserveTimeSlot(slotId); // Marquer le créneau comme réservé
    }

    @Override
    public void processDelivery(DeliveryEvent event) {
        System.out.println("Traitement de la livraison : " + event.getData());

        String slotId = (String) event.getData();
        timeSlotRepository.markAsDelivered(slotId); // Marquer le créneau comme livré
    }
    
}