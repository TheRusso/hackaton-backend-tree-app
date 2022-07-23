package com.it.revolution.trees.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "assigned_tree_task")
public class AssignedTreeTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Tree tree;

    @ManyToOne(fetch = FetchType.EAGER)
    private TreeTaskType taskType;

    @Enumerated(EnumType.STRING)
    private TreeTaskStatus status;

    @Column(name = "end_date")
    private Date endDate;

}
