package com.demo.security.demo;

import com.demo.security.config.JwtService;
import com.demo.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final JwtService jwtService;
    private final UserRepository repository;


    public DemoResponse getDemoResponse(String token) {
        // Extract the token from the Bearer token
        if (token != null && token.startsWith("Bearer ")) {
            String token2 = token.substring(7); // Remove "Bearer " part from the token
            // Print the token to the console
            System.out.println("JWT Token: " + token2);

            // Extract the username from the token
            var user = jwtService.extractUsername(token2);
            System.out.println("User: " + user);

            // Fetch the user data from the repository using the extracted username
            var data = repository.findByEmail(user)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            System.out.println("Data: " + data);

            // Return a DemoResponse object with the user's firstname
            return DemoResponse.builder()
                    .firstname(data.getFirstname())
                    .lastname(data.getLastname())
                    .email(data.getEmail())// Corrected the method call
                    .build();
        } else {
            System.out.println("No valid Bearer token found in Authorization header");
        }

        return null; // Handle case when there's no valid token
    }


}
