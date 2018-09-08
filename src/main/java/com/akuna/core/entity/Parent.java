package com.akuna.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "parent_id"))
})
public class Parent extends Person
{
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_to_parent",
    joinColumns = {@JoinColumn(name = "parent_id", referencedColumnName = "parent_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "student_id")})
    private List<Student> students;
}
