package com.it.revolution.trees.app.repository;

import com.it.revolution.trees.app.model.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

    @Query(value = "select nextval('tree_id_seq');", nativeQuery = true)
    Long getNextId();

    List<Tree> findAllByXBetweenAndYBetween(Double startX, Double endX, Double startY, Double endY);
}
