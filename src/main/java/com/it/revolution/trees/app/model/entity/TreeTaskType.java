package com.it.revolution.trees.app.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tree_task_type")
public class TreeTaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * Expected task time execution in hours.
     * */
    @Column(name = "execution_time")
    private Integer executionTime;


}
