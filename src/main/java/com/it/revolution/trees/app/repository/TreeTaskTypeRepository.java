package com.it.revolution.trees.app.repository;

import com.it.revolution.trees.app.model.entity.TreeTaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreeTaskTypeRepository extends JpaRepository<TreeTaskType, Long> {

}
