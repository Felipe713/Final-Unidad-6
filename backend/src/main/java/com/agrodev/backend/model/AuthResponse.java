package com.agrodev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class AuthResponse {

    @NotBlank
    private String email;

    @NotBlank
    private List<String> roles;
}
