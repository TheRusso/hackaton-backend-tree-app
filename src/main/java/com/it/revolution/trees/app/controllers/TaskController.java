package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.mapper.TreeMapper;
import com.it.revolution.trees.app.model.dto.TaskDto;
import com.it.revolution.trees.app.model.dto.TreeTaskTypeDto;
import com.it.revolution.trees.app.model.entity.TreeTaskType;
import com.it.revolution.trees.app.service.TreeTaskTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TreeTaskTypeService treeTaskTypeService;
    private final TreeMapper treeMapper;

    @GetMapping
    public List<TreeTaskTypeDto> getTreeTaskType() {
        List<TreeTaskType> treeTaskTypes = treeTaskTypeService.getTreeTaskTypes();
        return treeTaskTypes.stream()
                .map(treeMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
