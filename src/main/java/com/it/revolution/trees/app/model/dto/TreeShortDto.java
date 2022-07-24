package com.it.revolution.trees.app.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.revolution.trees.app.model.entity.TreeState;
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
    private TreeState state;

    @JsonProperty("x")
    private Double x;

    @JsonProperty("y")
    private Double y;

    @JsonProperty("radius")
    private Integer radius;

}
