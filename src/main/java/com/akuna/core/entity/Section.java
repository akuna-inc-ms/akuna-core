package com.akuna.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "section_id"))
})
public class Section extends AbstractEntity
{
    @Column(name = "section_name")
    private String sectionName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "section")
    private List<Group> groups;

    private double cost;
}
