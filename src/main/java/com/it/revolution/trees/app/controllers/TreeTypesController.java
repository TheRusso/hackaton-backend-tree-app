package com.it.revolution.trees.app.controllers;

import com.it.revolution.trees.app.model.entity.TreeType;
import com.it.revolution.trees.app.service.TreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tree/types")
@RequiredArgsConstructor
public class TreeTypesController {

    private final TreeService treeService;

    @GetMapping
    public ResponseEntity<List<TreeType>> allTreeTypes() {
        return ResponseEntity.ok(treeService.findAllTypes());
    }

}
