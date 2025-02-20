package com.delivery.infrastructure.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JwtTokenProviderTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    public void testGenerateToken() {
        String token = jwtTokenProvider.generateToken("test-user");
        assertNotNull(token);
        assertEquals("test-user", jwtTokenProvider.validateTokenAndRetrieveSubject(token));
    }
}
