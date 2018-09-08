package com.akuna.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "group_id"))
})
public class Group extends AbstractEntity
{
    @Column(name = "group_name")
    private String groupName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_to_group",
    joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "group_id")},
    inverseJoinColumns = {@JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")})
    private List<Teacher> teachers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_to_group",
    joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "group_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")})
    private List<Student> students;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", referencedColumnName = "section_id")
    private Section section;
}
