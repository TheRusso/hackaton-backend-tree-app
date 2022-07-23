package com.it.revolution.trees.app.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TreeTaskStatus {
    IN_PROGRESS("В процесі"),
    DONE("Виконано"),
    REJECTED("Відмінено")

    // placeholder
    ;

    private final String name;

}
