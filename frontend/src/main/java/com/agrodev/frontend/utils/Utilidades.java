package com.agrodev.frontend.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Utilidades {

    public static void guardarToken(String token, HttpServletResponse response) {
        Cookie tokenCookie = new Cookie("jwt_token", token);
        tokenCookie.setHttpOnly(true); // Asegura que la cookie no sea accesible mediante JavaScript
        tokenCookie.setSecure(true);  // Solo se envía en conexiones HTTPS (activar en producción)
        tokenCookie.setPath("/");     // Disponible para todas las rutas
        tokenCookie.setMaxAge(60 * 60 * 24); // Tiempo de vida: 1 día (en segundos)

        response.addCookie(tokenCookie);
        System.out.println("Token JWT guardado en la cookie");
    }

    public static String obtenerTokenJWT() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return null;
        }

        HttpServletRequest request = attributes.getRequest();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt_token".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
