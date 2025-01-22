package com.agrodev.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agrodev.frontend.service.UserServiceImpl;
import com.agrodev.frontend.model.LoginRequest;
import com.agrodev.frontend.utils.Utilidades;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public ModelAndView inicio() {
        System.out.println("Llega al controlador Front");
        return new ModelAndView("login");
    }

    /*
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        AuthResponse authResponse = userService.loginUser(loginRequest);
        Utilidades.guardarToken(authResponse.getJwt(), response);
        System.out.println("Paso por controlador Login en PostMapping");
        return ResponseEntity.ok("Inicio de sesión exitoso");
    }
    */

    @GetMapping("/alumnos")
    public String alumnos(Model model) {
        model.addAttribute("message", "Lista de alumnos");
        return "alumnos";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("message", "Lista de usuarios");
        return "usuarios";
    }
}
