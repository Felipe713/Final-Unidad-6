// package com.agrodev.frontend.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
// import org.springframework.web.client.RestTemplate;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     private RestTemplate restTemplate;

//     @Autowired
//     private MiProveedorAutenticacion miProveedorAutenticacion;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//         httpSecurity
//                 .csrf(csrf -> csrf.disable())
//                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers(new AntPathRequestMatcher("/"), new AntPathRequestMatcher("/login")).permitAll()
//                         .anyRequest().authenticated()
//                 )
//                 .formLogin(formLogin -> formLogin
//                         .loginPage("/login")
//                         .usernameParameter("username")
//                         .passwordParameter("password")
//                 )
//                 .httpBasic();

//         return httpSecurity.build();
//     }
// }
