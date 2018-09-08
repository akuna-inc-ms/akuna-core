package com.akuna.core.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Project
{
    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private String id;

    @CreatedDate
    @Column(name = "created_when")
    private Date createdWhen;

    @Column(name = "is_active")
    private boolean isActive;
}
