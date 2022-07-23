package com.it.revolution.trees.app.common.settings;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Backend {

    @NotNull
    private String host;

}
