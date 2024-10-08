package com.demo.security.demo;


import com.demo.security.config.JwtService;
import com.demo.security.user.User;
import com.demo.security.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {

    private final JwtService jwtService;
    private final DemoService demoService;

    @GetMapping
    public ResponseEntity<DemoResponse> sayHello(@RequestHeader("Authorization") String authHeader) {

        return ResponseEntity.ok(demoService.getDemoResponse(authHeader));
    }

}
