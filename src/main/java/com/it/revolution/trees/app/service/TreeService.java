package com.it.revolution.trees.app.service;

import com.it.revolution.trees.app.mapper.TreeMapper;
import com.it.revolution.trees.app.model.dto.TreeDto;
import com.it.revolution.trees.app.model.dto.TreeShortDto;
import com.it.revolution.trees.app.model.entity.Tree;
import com.it.revolution.trees.app.model.entity.TreeType;
import com.it.revolution.trees.app.repository.TreeRepository;
import com.it.revolution.trees.app.repository.TreeTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreeService {

    private final TreeRepository treeRepository;

    private final TreeTypeRepository typeRepository;

    private final TreeMapper treeMapper;

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

}
