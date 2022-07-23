package com.it.revolution.trees.app.model.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Represents authorized users rights.
 * @author Roman Kovalchuk
 * @version 1.0
 * */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
