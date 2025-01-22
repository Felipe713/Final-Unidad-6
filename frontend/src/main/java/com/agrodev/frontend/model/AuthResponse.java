package com.agrodev.frontend.model;

import lombok.Data;

@Data
public class AuthResponse {
    private String username;
    private String message;
    private String jwt;
    private boolean status;
}
