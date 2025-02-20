package com.delivery.infrastructure.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class JwtRequestFilterTest {

    private JwtTokenProvider jwtTokenProvider;
    private JwtRequestFilter filter;

    @BeforeEach
    void setUp() {
        jwtTokenProvider = mock(JwtTokenProvider.class);
        filter = new JwtRequestFilter(jwtTokenProvider);
    }

    @Test
    void testDoFilterInternal_ValidToken() throws ServletException, IOException {
        // Préparer les mocks
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer valid-token");

        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain filterChain = mock(FilterChain.class);

        when(jwtTokenProvider.validateToken("valid-token")).thenReturn(true);
        when(jwtTokenProvider.validateTokenAndRetrieveSubject("valid-token")).thenReturn("test-user");

        // Appeler la méthode à tester
        filter.doFilterInternal(request, response, filterChain);

        // Vérifier que l'authentification a été définie correctement
        SecurityContext context = SecurityContextHolder.getContext();
        assertTrue(context.getAuthentication() instanceof UsernamePasswordAuthenticationToken);
        assertEquals("test-user", context.getAuthentication().getName());

        // Vérifier que filterChain.doFilter a été appelé
        verify(filterChain).doFilter(request, response);
    }

    @Test
    void testDoFilterInternal_InvalidToken() throws ServletException, IOException {
        // Préparer les mocks
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Bearer invalid-token");

        MockHttpServletResponse response = new MockHttpServletResponse();
        FilterChain filterChain = mock(FilterChain.class);

        when(jwtTokenProvider.validateToken("invalid-token")).thenReturn(false);

        // Appeler la méthode à tester
        filter.doFilterInternal(request, response, filterChain);

        // Vérifier que l'authentification n'a pas été définie
        SecurityContext context = SecurityContextHolder.getContext();
        assertNull(context.getAuthentication());

        // Vérifier que filterChain.doFilter a été appelé
        verify(filterChain).doFilter(request, response);
    }
}