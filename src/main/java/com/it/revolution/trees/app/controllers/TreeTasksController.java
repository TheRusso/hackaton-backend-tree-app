package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.mapper.TreeTaskMapper;
import com.it.revolution.trees.app.model.dto.TreeTaskTypeDto;
import com.it.revolution.trees.app.service.TreeTaskTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tree/tasks")
@CrossOrigin
@RequiredArgsConstructor
public class TreeTasksController {

    private final TreeTaskTypeService taskService;

    private final TreeTaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TreeTaskTypeDto>> getTaskTypes() {
        return ResponseEntity.ok(taskMapper.mapEntitiesToDtos(taskService.getTreeTaskTypes()));
    }

}
