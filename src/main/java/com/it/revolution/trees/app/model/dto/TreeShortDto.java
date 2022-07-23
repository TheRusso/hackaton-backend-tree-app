package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TreeShortDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("registrationNumber")
    private String registrationNumber;

    @JsonProperty("photoUrl")
    private String photoUrl;

    @JsonProperty("state")
    private String state;

}
