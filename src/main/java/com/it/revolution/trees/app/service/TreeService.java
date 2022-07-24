package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.amazon.service.FileService;
import com.it.revolution.trees.app.mapper.TreeMapper;
import com.it.revolution.trees.app.model.dto.AddTreeRequestDto;
import com.it.revolution.trees.app.model.dto.AddTreeTaskRequestDto;
import com.it.revolution.trees.app.model.dto.TreeDto;
import com.it.revolution.trees.app.model.dto.TreeShortDto;
import com.it.revolution.trees.app.model.entity.*;
import com.it.revolution.trees.app.repository.AssignedTreeTaskRepository;
import com.it.revolution.trees.app.repository.TreeRepository;
import com.it.revolution.trees.app.repository.TreeTaskTypeRepository;
import com.it.revolution.trees.app.repository.TreeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class TreeService {

    private final TreeRepository treeRepository;

    private final TreeTypeRepository typeRepository;

    private final TreeTaskTypeRepository taskTypeRepository;

    private final AssignedTreeTaskRepository assignedTreeTaskRepository;

    private final TreeMapper treeMapper;

    private final FileService fileService;

    public Tree findById(Long id) {
        return treeRepository.findById(id).orElse(null);
    }

    public List<TreeShortDto> getTreeShortList(Double startX, Double endX, Double startY, Double endY) {
        List<Tree> treeList = treeRepository.findAllByXBetweenAndYBetween(startX, endX, startY, endY);
        return treeList.stream()
                .map(treeMapper::mapToShortDto)
                .collect(Collectors.toList());
    }

    public Optional<TreeDto> findTree(Long id) {
        return treeRepository.findById(id)
                .map(treeMapper::mapToDto);
    }

    public List<TreeType> findAllTypes(){
        return typeRepository.findAll();
    }

    public TreeTaskType findTaskTypeById(Long id) {
        return taskTypeRepository.findById(id).orElse(null);
    }

    public Tree createTree(AddTreeRequestDto treeDto, MultipartFile photo) {

        Tree tree = treeMapper.mapToEntity(treeDto);
        if (nonNull(photo)) {
            String url = fileService.uploadFile(photo);
            tree.setPhotoUrl(url);
        }

        Tree created = treeRepository.save(tree);

        if (nonNull(treeDto.getTasks())) {
            List<AssignedTreeTask> assigned = treeDto.getTasks().stream().map(t -> mapToEntity(t, created)).collect(Collectors.toList());
            assignedTreeTaskRepository.saveAll(assigned);
        }
        return created;
    }

    private AssignedTreeTask mapToEntity(AddTreeTaskRequestDto taskRequestDto, Tree tree) {
        AssignedTreeTask assigned = new AssignedTreeTask();
        TreeTaskType taskType = taskTypeRepository.findById(taskRequestDto.getId()).orElse(null);
        assigned.setTaskType(taskType);
        assigned.setStatus(TreeTaskStatus.IN_PROGRESS);
        assigned.setTree(tree);
        return assigned;

    }


}
