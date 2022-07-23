package com.it.revolution.trees.app.repository;

import com.it.revolution.trees.app.model.entity.Tree;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends PagingAndSortingRepository<Tree, Long> {
    List<Tree> findAllByXBetweenAndYBetween(Double startX, Double endX, Double startY, Double endY);
}
