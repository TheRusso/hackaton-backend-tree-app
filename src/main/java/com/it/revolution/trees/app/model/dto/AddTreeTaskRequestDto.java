package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddTreeTaskRequestDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
