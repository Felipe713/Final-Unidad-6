package com.agrodev.backend.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({ "username", "message", "jwt", "status", "roles" })
public record AuthResponse(
        String username,
        String message,
        String jwt,
        boolean status,
        List<String> roles // Agregamos la lista de roles
) {}

