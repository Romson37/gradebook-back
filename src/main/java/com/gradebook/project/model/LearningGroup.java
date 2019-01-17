package com.gradebook.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "learning_Groups")
public class LearningGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private String groupId;

    @OneToMany(mappedBy = "group")
    @JsonBackReference(value = "student_group")
    private Set<Student> students = new HashSet<Student>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "teachers_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    @JsonBackReference(value = "teacher_group")
    private List<Teacher> teachers = new ArrayList<>();
}
