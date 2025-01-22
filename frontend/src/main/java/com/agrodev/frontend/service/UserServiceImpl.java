package com.agrodev.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.agrodev.frontend.model.AuthResponse;
import com.agrodev.frontend.model.LoginRequest;

@Service
public class UserServiceImpl {

    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AuthResponse loginUser(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json"); // Agregamos un encabezado por defecto

        HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest, headers);

        try {
            ResponseEntity<AuthResponse> response = restTemplate.postForEntity(
                    "http://localhost:8080/auth/log-in",
                    entity,
                    AuthResponse.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al iniciar sesión: " + e.getMessage(), e);
        }

        throw new RuntimeException("Error al iniciar sesión: Respuesta inválida.");
    }
}
