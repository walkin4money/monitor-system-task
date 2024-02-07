package com.example.monitorsystemtask.controller;


import com.example.monitorsystemtask.dto.JwtRequestDTO;
import com.example.monitorsystemtask.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class AuthController {

    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequestDTO jwtRequestDto){
      return authService.login(jwtRequestDto);
    }

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
}
