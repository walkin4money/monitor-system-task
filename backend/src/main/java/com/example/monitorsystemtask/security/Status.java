package com.example.monitorsystemtask.security;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("ACTIVE"),
    BANNED("BANNED");
    String status;

    Status(String status){
        this.status = status;
    }
}
