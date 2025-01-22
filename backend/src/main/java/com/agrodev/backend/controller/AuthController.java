package com.agrodev.backend.controller;

import com.agrodev.backend.dto.AuthLoginRequest;
import com.agrodev.backend.dto.AuthResponse;
import com.agrodev.backend.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailService;

    @PostMapping("/log-in")
    public void login(@Validated @RequestBody AuthLoginRequest userRequest) {
        System.out.println("Llego al backend");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userRequest.username(), userRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var userDetails = (UserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        AuthResponse authResponse = new AuthResponse(
                userDetails.getUsername(),
                "Login exitoso", // Puedes usar un mensaje fijo o dinámico.
                "JWT_TOKEN", // Aquí debes insertar el token JWT generado.
                true, // Status de autenticación.
                roles // Pasar la lista de roles.
        );

    }

}
