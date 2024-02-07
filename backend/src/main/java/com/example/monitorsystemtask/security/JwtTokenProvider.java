package com.example.monitorsystemtask.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;


@Component
public class JwtTokenProvider {
    @Value("${jwt.lifetime}")
    Duration lifetime;
    @Value("${jwt.secretKey}")
    String secretKey;

    @Autowired
    CustomUserDetailsService customUserDetailsService;
    @Autowired
    ModelMapper modelMapper;

    public String generateJwtToken(String username) {
        UserDetails securityUser = customUserDetailsService.loadUserByUsername(username);
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("authorities", securityUser.getAuthorities());
        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + lifetime.toMillis());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(securityUser.getUsername())
                .setIssuedAt(issuedDate)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
    }
    public Authentication getAuthentication(String token) {
        return new UsernamePasswordAuthenticationToken(
                getUsernameFromToken(token),
                null,
                getAuthoritiesFromToken(token)
        );
    }
    public String resolveToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer "))
            return request.getHeader("Authorization").substring(7);
        return null;
    }

    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    public Collection<? extends GrantedAuthority> getAuthoritiesFromToken(String token) {
        return customUserDetailsService.loadUserByUsername(getUsernameFromToken(token)).getAuthorities();
    }
}
