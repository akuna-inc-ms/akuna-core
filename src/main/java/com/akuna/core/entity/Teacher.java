package com.akuna.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "teacher_id"))
})
public class Teacher extends Person
{
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teachers")
    private List<Group> groups;
}
