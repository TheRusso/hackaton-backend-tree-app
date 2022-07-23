package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.model.entity.TreeTaskType;
import com.it.revolution.trees.app.repository.TreeTaskTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreeTaskTypeService {

    private final TreeTaskTypeRepository taskRepository;

    public List<TreeTaskType> getTreeTaskTypes() {
        List<TreeTaskType> treeTaskTypeList = new ArrayList<>();
        taskRepository.findAll()
                .forEach(treeTaskTypeList::add);
        return treeTaskTypeList;
    }

}
