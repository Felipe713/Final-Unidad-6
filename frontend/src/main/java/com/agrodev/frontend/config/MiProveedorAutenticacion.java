// package com.agrodev.frontend.config;

// import java.util.ArrayList;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.stereotype.Component;
// import com.agrodev.frontend.model.LoginRequest;
// import com.agrodev.frontend.model.AuthResponse;
// import com.agrodev.frontend.service.UserServiceImpl;

// @Component
// public class MiProveedorAutenticacion implements AuthenticationProvider {

//     @Autowired
//     private UserServiceImpl userService;

//     @Override
//     public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//         String username = authentication.getName();
//         String password = authentication.getCredentials().toString();

//         LoginRequest loginRequest = new LoginRequest(username, password);
//         AuthResponse authResponse = userService.loginUser(loginRequest);

//         if (authResponse != null) {
//             String token = authResponse.getJwt();
//             System.out.println("Token: " + token);
//             return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
//         } else {
//             System.out.println("Authentication failed");
//             return null;
//         }
//     }

//     @Override
//     public boolean supports(Class<?> authentication) {
//         return authentication.equals(UsernamePasswordAuthenticationToken.class);
//     }
// }
