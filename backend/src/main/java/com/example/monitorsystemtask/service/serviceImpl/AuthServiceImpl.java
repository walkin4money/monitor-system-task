package com.example.monitorsystemtask.service.serviceImpl;

import com.example.monitorsystemtask.dto.JwtRequestDTO;
import com.example.monitorsystemtask.security.JwtTokenProvider;
import com.example.monitorsystemtask.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    AuthenticationManager authenticationManager;
    JwtTokenProvider jwtTokenProvider;

    @Override
    public ResponseEntity<Map<String,Object>> login(JwtRequestDTO jwtRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestDto.getUsername(), jwtRequestDto.getPassword()));
        String token = jwtTokenProvider.generateJwtToken(jwtRequestDto.getUsername());
        Map<String,Object> response = new HashMap<>();
        response.put("username",jwtRequestDto.getUsername());
        response.put("token",token);
        response.put("authorities", jwtTokenProvider.getAuthoritiesFromToken(token));
        return ResponseEntity.ok(response);
    }

    @Autowired
    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }
}
