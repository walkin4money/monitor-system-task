package com.example.monitorsystemtask.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    JwtTokenProvider jwtTokenProvider;
    ModelMapper modelMapper;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
           String token = jwtTokenProvider.resolveToken(request);
            if(token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                Authentication authentication = jwtTokenProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        filterChain.doFilter(request,response);
    }

    @Autowired
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider,ModelMapper modelMapper){
        this.jwtTokenProvider = jwtTokenProvider;
        this.modelMapper = modelMapper;
    }

}
