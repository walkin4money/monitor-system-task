package com.example.monitorsystemtask.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.USER_READING)),
    ADMIN(Set.of(Permission.USER_READING,Permission.USER_WRITING,Permission.USER_DELETING,Permission.USER_UPDATING));

    Set<Permission> permissions;
    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities(){
       return permissions.stream().map(p->new SimpleGrantedAuthority(p.getPermission())).collect(Collectors.toSet());
    }

}
