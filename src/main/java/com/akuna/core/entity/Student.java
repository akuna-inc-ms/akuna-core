package com.akuna.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "student_id"))
})
public class Student extends Person
{
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    private List<Group> groups;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "students")
    private List<Parent> parents;
}
