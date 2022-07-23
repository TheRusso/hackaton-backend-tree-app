package com.it.revolution.trees.app.security.jwt.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
