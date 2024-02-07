package com.example.monitorsystemtask.entity;

import com.example.monitorsystemtask.security.Role;
import com.example.monitorsystemtask.security.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "username",length = 40)
    String username;

    @Column(name="password",length = 200)
    String password;

    @Column(name="Role",length = 30)
    @Enumerated(value = EnumType.STRING)
    Role role;

    @Column(name="Status",length = 30)
    @Enumerated(value = EnumType.STRING)
    Status status;

}
