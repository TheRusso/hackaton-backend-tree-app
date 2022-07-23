package com.it.revolution.trees.app.mapper;

import com.it.revolution.trees.app.model.dto.TreeDto;
import com.it.revolution.trees.app.model.dto.TreeShortDto;
import com.it.revolution.trees.app.model.entity.Tree;
import com.it.revolution.trees.app.model.entity.TreeState;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return null;
    }
}
