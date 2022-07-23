package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.model.dto.TreeDto;
import com.it.revolution.trees.app.model.dto.TreeShortDto;
import com.it.revolution.trees.app.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/trees")
public class TreeController {

    private final TreeService treeService;

    @GetMapping
    public ResponseEntity<List<TreeShortDto>> getListTreeShort(@PathParam("startX") Double startX,
                                                               @PathParam("endX") Double endX,
                                                               @PathParam("startY") Double startY,
                                                               @PathParam("endY") Double endY) {
        List<TreeShortDto> trees = treeService.getTreeShortList(startX, endX, startY, endY);
        return ResponseEntity.ok(trees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDto> getTree(@PathVariable("id") Long id) {
        return ResponseEntity.of(treeService.findTree(id));
    }

}
