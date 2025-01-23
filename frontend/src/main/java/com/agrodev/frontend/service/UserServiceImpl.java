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

    @Autowired
    RestTemplate restTemplate;

    public AuthResponse loginUser(LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json"); // Agregamos un encabezado por defecto

        // Para fines de referencia como ultimo recurso
        // headers.add("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBVVRISldUMC1CQUNLRU5EIiwic3ViIjoiYWRtaW5pc3RyYWRvckBtYWlsLmNvbSIsImF1dGhvcml0aWVzIjoiQ1JFQVRFLERFTEVURSxSRUFELFJPTEVfQURNSU4sUk9MRV9JTlZJVEVELFJPTEVfVVNFUixVUERBVEUiLCJpYXQiOjE3Mzc2NTM1MjAsImV4cCI6MTczNzY1NTMyMCwianRpIjoiMDFkMzQ0YTktYzkxYS00ZDVkLWJjNjktMjdjZGY1YmRiYzM0IiwibmJmIjoxNzM3NjUzNTIwfQ._afsyeGepYP5HNFA1RX-5JF2x7ONANOiB3_iaQws_eg");

        /* ****************** NO FUNCIONA SE DEBE ADAPTARR *************************** */
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // headers.add("Authorization", "Bearer " + tokenUtilities.obtenerJWT());
        /* ****************** NO FUNCIONA SE DEBE ADAPTARR *************************** */

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
