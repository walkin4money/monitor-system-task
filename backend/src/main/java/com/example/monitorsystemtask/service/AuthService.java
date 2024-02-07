package com.example.monitorsystemtask.service;

import com.example.monitorsystemtask.dto.JwtRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AuthService {
    ResponseEntity<Map<String,Object>> login(JwtRequestDTO jwtRequestDto);
}
