package com.it.revolution.trees.app.repository;

import com.it.revolution.trees.app.model.entity.TreeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeTypeRepository extends JpaRepository<TreeType, Long> {

}
