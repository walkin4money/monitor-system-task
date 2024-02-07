package com.example.monitorsystemtask.configure;

import com.example.monitorsystemtask.exception.FilterExceptionHandler;
import com.example.monitorsystemtask.exception.AccessDeniedHandler;
import com.example.monitorsystemtask.security.JwtAuthenticationEntryPoint;
import com.example.monitorsystemtask.security.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigure  {
    UserDetailsService userDetailsService;
    JwtTokenFilter jwtTokenFilter;
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    FilterExceptionHandler filterExceptionHandler;
    AccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(r->
                        r.requestMatchers(HttpMethod.GET,"api/sensors","api/sensors/{id}").hasAuthority("user:reading")
                                .requestMatchers(HttpMethod.POST,"api/sensors").hasAuthority("user:writing")
                                .requestMatchers(HttpMethod.PATCH,"api/sensors/{id}").hasAuthority("user:updating")
                                .requestMatchers(HttpMethod.DELETE,"api/sensors/{id}").hasAuthority("user:deleting")
                                .anyRequest().permitAll()
                )
                //.exceptionHandling(e->e.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .sessionManagement(m->m.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(filterExceptionHandler,JwtTokenFilter.class)
                .exceptionHandling(e->e.accessDeniedHandler(accessDeniedHandler));
         return httpSecurity.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    public SecurityConfigure(UserDetailsService userDetailsService, JwtTokenFilter jwtTokenFilter,JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,FilterExceptionHandler filterExceptionHandler,AccessDeniedHandler accessDeniedHandler){
        this.userDetailsService = userDetailsService;
        this.jwtTokenFilter = jwtTokenFilter;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.filterExceptionHandler = filterExceptionHandler;
        this.accessDeniedHandler = accessDeniedHandler;
    }
}
