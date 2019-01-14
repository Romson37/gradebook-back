package com.gradebook.project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Integer teachersId;

    @Column(name = "name")
    private String teachersName;

    @Column(name = "surname")
    private String teachersSurname;

    @Column(name = "email")
    private String teachersEmail;

    @Column(name = "subject")
    private String subject;

    @ManyToMany(mappedBy = "teachers")
    @JsonBackReference(value = "teacher_group")
    private Set<LearningGroup> learningGroups = new HashSet<>();

    @OneToOne()
    @JoinColumn(name = "username")
    @JsonBackReference(value = "teacher_user")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "teacher", orphanRemoval = true)
    @JsonBackReference(value = "teacher_mark")
    private Set<Mark> marks = new HashSet<>();
}
