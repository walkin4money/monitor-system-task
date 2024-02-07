package com.example.monitorsystemtask.exception;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FilterAdvice {

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<Map<String,Object>> handleExpiredJwtException(ExpiredJwtException expiredJwtException){
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("message","The token has expired");
        responseBody.put("status",HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

    @ExceptionHandler(MalformedJwtException.class)
    public ResponseEntity<Map<String,Object>> handleMalformedJwtException(MalformedJwtException malformedJwtException){
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("message","Incorrect token format");
        responseBody.put("status",HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

    @ExceptionHandler(io.jsonwebtoken.security.SignatureException.class)
    public ResponseEntity<Map<String,Object>> handleMalformedJwtException(io.jsonwebtoken.security.SignatureException signatureException){
        Map<String,Object> responseBody = new HashMap<>();
        responseBody.put("message","The token signature is corrupted");
        responseBody.put("status",HttpStatus.UNAUTHORIZED);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

}
