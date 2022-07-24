package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class TreeTaskTypeDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
