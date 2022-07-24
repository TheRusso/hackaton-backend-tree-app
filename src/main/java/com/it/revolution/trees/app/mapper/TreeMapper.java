package com.it.revolution.trees.app.mapper;

import com.it.revolution.trees.app.model.dto.*;
import com.it.revolution.trees.app.model.entity.*;
import com.it.revolution.trees.app.repository.TreeRepository;
import com.it.revolution.trees.app.repository.TreeTaskTypeRepository;
import com.it.revolution.trees.app.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class TreeMapper {

    private final TreeTaskTypeRepository treeTaskTypeRepository;

    private final TreeRepository treeRepository;

    public TreeShortDto mapToShortDto(Tree tree) {

        TreeShortDto dto = new TreeShortDto();
        dto.setId(tree.getId());
        dto.setState(tree.getState());
        dto.setPhotoUrl(tree.getPhotoUrl());
        dto.setRegistrationNumber(tree.getRegistrationNumber());
        dto.setX(tree.getX());
        dto.setY(tree.getY());
        dto.setRadius(tree.getRadius());
        return dto;
    }

    public TreeDto mapToDto(Tree tree) {

        TreeTypeDto treeTypeDto = mapToDto(tree.getType());

        TreeDto treeDto = new TreeDto();
        treeDto.setId(tree.getId());
        treeDto.setPhotoUrl(tree.getPhotoUrl());
        treeDto.setX(tree.getX());
        treeDto.setY(tree.getY());
        treeDto.setState(tree.getState());
        treeDto.setRadius(tree.getRadius());
        treeDto.setBirthDate(tree.getBirthDate());
        treeDto.setType(treeTypeDto);
        treeDto.setTasks(mapToDtos(tree.getTasks()));

        return treeDto;
    }

    public List<TaskDto> mapToDtos(List<AssignedTreeTask> assignedTreeTasks) {
        return Optional.ofNullable(assignedTreeTasks).orElseGet(ArrayList::new).stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public TaskDto mapToDto(AssignedTreeTask assignedTreeTask) {
        Integer executionTime = Optional.ofNullable(assignedTreeTask.getTaskType())
                .map(TreeTaskType::getExecutionTime)
                .orElse(null);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(assignedTreeTask.getId());
        taskDto.setName(assignedTreeTask.getTaskType().getName());
        taskDto.setStatus(assignedTreeTask.getStatus());
        taskDto.setExpectedExecutionTime(executionTime);
        return taskDto;
    }

    public TreeTypeDto mapToDto(TreeType treeType) {
        TreeTypeDto treeTypeDto = new TreeTypeDto();
        treeTypeDto.setId(treeType.getId());
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


    public Tree mapToEntity(AddTreeRequestDto treeDto) {
        Tree tree = new Tree();
        Long nextId = treeRepository.getNextId();
        tree.setId(nextId);
        tree.setRegistrationNumber(String.format("%010d", nextId));
        tree.setX(treeDto.getX());
        tree.setY(treeDto.getY());
        tree.setRadius(treeDto.getRadius());
        tree.setType(treeDto.getType());
        tree.setState(treeDto.getState());
        tree.setBirthDate(treeDto.getBirthDate());
        return tree;
    }


    public AssignedTreeTask mapToEntity(AddTreeTaskRequestDto taskRequestDto, Tree tree) {
        AssignedTreeTask assigned = new AssignedTreeTask();
        TreeTaskType taskType = treeTaskTypeRepository.findById(taskRequestDto.getId()).orElse(null);
        assigned.setTaskType(taskType);
        assigned.setStatus(TreeTaskStatus.IN_PROGRESS);
        assigned.setTree(tree);
        return assigned;
    }

}
