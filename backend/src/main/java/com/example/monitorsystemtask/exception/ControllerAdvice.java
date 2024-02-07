package com.example.monitorsystemtask.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(LockedException.class)
    public ResponseEntity<Map<String,Object>> handleLockedException(LockedException lockedException){
        Map<String,Object> response = new HashMap<>();
        response.put("message","This user is banned");
        response.put("status",HttpStatus.FORBIDDEN);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(SensorNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleSensorNotFoundException(SensorNotFoundException sensorNotFoundException){
        Map<String,Object> response = new HashMap<>();
        response.put("message",sensorNotFoundException.getMessage());
        response.put("status",HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidRangeException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidRangeException(InvalidRangeException invalidRangeException){
        Map<String,Object> response = new HashMap<>();
        response.put("message",invalidRangeException.getMessage());
        response.put("status", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String,Object>> handleIBadCredentialsException(BadCredentialsException badCredentialsException){
        Map<String,Object> response = new HashMap<>();
        response.put("message","Incorrect login or password");
        response.put("status", HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

}
