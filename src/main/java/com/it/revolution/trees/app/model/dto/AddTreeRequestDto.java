package com.it.revolution.trees.app.model.dto;


import com.it.revolution.trees.app.model.entity.TreeState;
import com.it.revolution.trees.app.model.entity.TreeType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AddTreeRequestDto {

    private Double x;

    private Double y;

    private Integer radius;

    private TreeState state;

    private TreeType type;

    private List<AddTreeTaskRequestDto> tasks;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime birthDate;
}
