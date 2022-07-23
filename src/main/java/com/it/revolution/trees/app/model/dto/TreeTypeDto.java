package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TreeTypeDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

}
