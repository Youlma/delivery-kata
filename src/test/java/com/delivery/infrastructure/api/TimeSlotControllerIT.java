package com.delivery.infrastructure.api;


import com.delivery.domain.model.TimeSlot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TimeSlotControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReserveTimeSlot() throws Exception {
        TimeSlot timeSlot = new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        mockMvc.perform(post("/time-slots/reserve")
                .contentType("application/json")
                .content("{\"startDateTime\": \"" + timeSlot.getStartDateTime() + "\", \"endDateTime\": \"" + timeSlot.getEndDateTime() + "\"}"))
                .andExpect(status().isOk());
    }
}
