package com.example.monitorsystemtask.security;

import lombok.Getter;

@Getter
public enum Permission {
    USER_READING("user:reading"),
    USER_WRITING("user:writing"),
    USER_DELETING("user:deleting"),
    USER_UPDATING("user:updating");
    String permission;
    Permission(String permission) {
      this.permission = permission;
    }

}
