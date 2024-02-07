package com.example.monitorsystemtask.security;

import com.example.monitorsystemtask.entity.UserEntity;
import com.example.monitorsystemtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return toSecurityUser(username);
    }

    SecurityUser toSecurityUser(String username){
        UserEntity userEntity = findByUsername(username);
        return new SecurityUser(userEntity.getUsername(),userEntity.getPassword(),userEntity.getRole().getAuthorities(),userEntity.getStatus());
    }

}
