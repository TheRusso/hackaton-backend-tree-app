package com.it.revolution.trees.app.mapper;

import com.it.revolution.trees.app.model.dto.TreeTaskTypeDto;
import com.it.revolution.trees.app.model.entity.TreeTaskType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreeTaskMapper {

    public TreeTaskTypeDto mapEntityToDto(TreeTaskType treeTaskType) {
        TreeTaskTypeDto treeTaskTypeDto = new TreeTaskTypeDto();
        treeTaskTypeDto.setId(treeTaskType.getId());
        treeTaskTypeDto.setName(treeTaskType.getName());
        return treeTaskTypeDto;
    }

    public TreeTaskType mapDtoToEntity(TreeTaskTypeDto treeTaskTypeDto) {
        TreeTaskType taskType = new TreeTaskType();
        taskType.setId(taskType.getId());
        taskType.setName(treeTaskTypeDto.getName());
        return taskType;
    }

    public List<TreeTaskType> mapDtosToEntities(List<TreeTaskTypeDto> dtos) {
        return dtos.stream().map(this::mapDtoToEntity).collect(Collectors.toList());
    }

    public List<TreeTaskTypeDto> mapEntitiesToDtos(List<TreeTaskType> dtos) {
        return dtos.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

}
