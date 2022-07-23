package com.it.revolution.trees.app.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TreeState {
    DISREPAIR("Аварійний"),
    ILL("Хворий"),
    HEALTHY("Здоровий")

    // placeholder
    ;

    private final String name;

}
