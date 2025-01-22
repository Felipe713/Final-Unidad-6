package com.agrodev.frontend.model;

import lombok.Data;
import java.util.Set;

@Data
public class Usuario {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;
}
