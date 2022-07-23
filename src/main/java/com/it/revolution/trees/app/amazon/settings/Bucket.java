package com.it.revolution.trees.app.amazon.settings;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Bucket {

    @NotNull
    private String name;

}
