package com.it.revolution.trees.app.repository;

import com.it.revolution.trees.app.model.entity.AssignedTreeTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignedTreeTaskRepository extends JpaRepository<AssignedTreeTask, Long> {
}
