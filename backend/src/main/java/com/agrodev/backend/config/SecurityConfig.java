package com.agrodev.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.agrodev.backend.config.filter.JwtTokenValidator;
import com.agrodev.backend.service.UserDetailsServiceImpl;
import com.agrodev.backend.utils.JwtUtils;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    JwtUtils jwtUtil;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF para simplificar la autenticación basada en tokens
                // .cors(Customizer.withDefaults()) // Habilita CORS
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // Control de sesiones
                .authorizeHttpRequests(http -> {

                    http.requestMatchers(HttpMethod.GET, "/auth/**").permitAll();
                    http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();

                    http.requestMatchers(HttpMethod.GET, "/api/v1/alumnos/**", "/api/v1/materias/**").hasAuthority("ROLE_INVITED");
                    http.requestMatchers(HttpMethod.POST, "/api/v1/alumnos/**", "/auth/**", "/api/v1/materias/**").hasAuthority("ROLE_USER");
                    http.requestMatchers(HttpMethod.PUT, "/api/v1/alumnos/**", "/auth/**", "/api/v1/materias/**").hasAuthority("ROLE_ADMIN");
                    http.requestMatchers(HttpMethod.DELETE, "/api/v1/alumnos/**", "/auth/**", "/api/v1/materias/**").hasAuthority("ROLE_ADMIN");
                    http.anyRequest().authenticated(); // Proteger todas las demás rutas
                })
                .httpBasic(Customizer.withDefaults()); // Configuración básica de autenticación
                // .addFilterBefore(new JwtTokenValidator(jwtUtil), BasicAuthenticationFilter.class); // Filtro JWT

        return httpSecurity.build();
    }

    // @Bean
    // public CorsFilter corsFilter() {
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     CorsConfiguration config = new CorsConfiguration();
    //     config.setAllowCredentials(true); // Permitir credenciales (cookies, encabezados)
    //     config.addAllowedOrigin("http://localhost:8081"); // Agrega la URL de tu frontend
    //     config.addAllowedHeader("*"); // Permitir todos los encabezados
    //     config.addAllowedMethod("*"); // Permitir todos los métodos HTTP (GET, POST, etc.)
    //     config.addExposedHeader("Authorization"); // Exponer encabezados específicos como el token JWT
    //     source.registerCorsConfiguration("/**", config);
    //     return new CorsFilter(source);
    // }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
      return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsServiceImpl userDetailService){
      
      DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
      authenticationProvider.setPasswordEncoder(passwordEncoder());
      authenticationProvider.setUserDetailsService(userDetailService);
      return authenticationProvider;
      
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
