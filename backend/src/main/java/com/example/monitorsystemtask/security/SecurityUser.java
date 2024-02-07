package com.example.monitorsystemtask.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class SecurityUser implements UserDetails {

    private String username;
    private String password;
    private Set<SimpleGrantedAuthority> authoritySet;

    private Status status;

    public SecurityUser(String username, String password, Set<SimpleGrantedAuthority> authoritySet,Status status) {
        this.username = username;
        this.password = password;
        this.authoritySet = authoritySet;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authoritySet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return Objects.equals(status.getStatus(), Status.ACTIVE.getStatus());
    }

    @Override
    public boolean isAccountNonLocked() {
        return Objects.equals(status.getStatus(), Status.ACTIVE.getStatus());
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Objects.equals(status.getStatus(), Status.ACTIVE.getStatus());
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(status.getStatus(), Status.ACTIVE.getStatus());
    }
}
