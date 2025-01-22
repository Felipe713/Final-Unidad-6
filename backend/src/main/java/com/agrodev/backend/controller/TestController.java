package com.agrodev.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @GetMapping("/users")
    public String hola() {
        return "público";
    }

    @GetMapping("/privado")
    public String holaPrivado() {
        return "privado";
    }

    @GetMapping("/config")
    public String config() {
        return "config";
    }
}
