package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.mapper.TreeMapper;
import com.it.revolution.trees.app.model.dto.AddTreeRequestDto;
import com.it.revolution.trees.app.model.dto.AddTreeTaskRequestDto;
import com.it.revolution.trees.app.model.dto.TreeDto;
import com.it.revolution.trees.app.model.dto.TreeShortDto;
import com.it.revolution.trees.app.model.entity.AssignedTreeTask;
import com.it.revolution.trees.app.model.entity.Tree;
import com.it.revolution.trees.app.model.entity.TreeTaskStatus;
import com.it.revolution.trees.app.model.entity.TreeTaskType;
import com.it.revolution.trees.app.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trees")
public class TreeController {

    private final TreeService treeService;

    @GetMapping
    public ResponseEntity<List<TreeShortDto>> getListTreeShort(@RequestParam("startX") Double startX,
                                                               @RequestParam("endX") Double endX,
                                                               @RequestParam("startY") Double startY,
                                                               @RequestParam("endY") Double endY) {
        List<TreeShortDto> trees = treeService.getTreeShortList(startX, endX, startY, endY);
        return ResponseEntity.ok(trees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDto> getTree(@PathVariable("id") Long id) {
        return ResponseEntity.of(treeService.findTree(id));
    }

    @PostMapping
    public ResponseEntity<Tree> create(AddTreeRequestDto treeDto,
                                       @RequestParam(name = "photo", required = false) MultipartFile photo) {
        return ResponseEntity.ok(treeService.createTree(treeDto, photo));
    }

}
