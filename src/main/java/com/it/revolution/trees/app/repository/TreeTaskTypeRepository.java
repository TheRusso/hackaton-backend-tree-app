package com.it.revolution.trees.app.repository;

import com.it.revolution.trees.app.model.entity.TreeTaskType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeTaskTypeRepository extends CrudRepository<TreeTaskType, Long> {
}
