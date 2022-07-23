package com.it.revolution.trees.app.mapper;

import com.it.revolution.trees.app.model.dto.*;
import com.it.revolution.trees.app.model.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreeMapper {

    public TreeShortDto mapToShortDto(Tree tree) {
        String stateName = Optional.ofNullable(tree.getState())
                .map(TreeState::getName)
                .orElse(null);

        TreeShortDto dto = new TreeShortDto();
        dto.setId(tree.getId());
        dto.setState(stateName);
        dto.setPhotoUrl(tree.getPhotoUrl());
        dto.setRegistrationNumber(tree.getRegisterNumber());
        return dto;
    }

    public TreeDto mapToDto(Tree tree) {
        String state = Optional.ofNullable(tree.getState())
                .map(TreeState::getName)
                .orElse(null);
        TreeTypeDto treeTypeDto = mapToDto(tree.getType());

        TreeDto treeDto = new TreeDto();
        treeDto.setId(tree.getId());
        treeDto.setPhotoUrl(tree.getPhotoUrl());
        treeDto.setState(state);
        treeDto.setRadius(tree.getRadius());
        treeDto.setBirthDate(tree.getBirthDate());
        treeDto.setType(treeTypeDto);
        treeDto.setTasks(mapToDtos(tree.getTasks()));

        return treeDto;
    }

    public List<TaskDto> mapToDtos(List<AssignedTreeTask> assignedTreeTasks) {
        return assignedTreeTasks.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public TaskDto mapToDto(AssignedTreeTask assignedTreeTask) {
        String status = Optional.ofNullable(assignedTreeTask.getStatus())
                .map(TreeTaskStatus::getName)
                .orElse(null);
        Integer executionTime = Optional.ofNullable(assignedTreeTask.getTaskType())
                .map(TreeTaskType::getExecutionTime)
                .orElse(null);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(assignedTreeTask.getId());
        taskDto.setStatus(status);
        taskDto.setExpectedExecutionTime(executionTime);
        return taskDto;
    }

    public TreeTypeDto mapToDto(TreeType treeType) {
        TreeTypeDto treeTypeDto = new TreeTypeDto();
        treeTypeDto.setName(treeType.getName());
        treeTypeDto.setDescription(treeType.getDescription());
        return treeTypeDto;
    }

    public TreeTaskTypeDto mapToDto(TreeTaskType treeTaskType) {
        TreeTaskTypeDto taskDto = new TreeTaskTypeDto();
        taskDto.setId(treeTaskType.getId());
        taskDto.setName(treeTaskType.getName());
        return taskDto;
    }
}
