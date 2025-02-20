package com.delivery.infrastructure.security;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JwtTokenProviderTest {

    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void testGenerateToken() {
        String token = jwtTokenProvider.generateToken("test-user");
        Mockito.when(jwtTokenProvider.validateTokenAndRetrieveSubject(token)).thenReturn("test-user");

        assertEquals("test-user", jwtTokenProvider.validateTokenAndRetrieveSubject(token));
    }
}