package com.prep.prep.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "Student")
public class StudentEntity {
    @Id
    private Integer id;
    private String name;
    private String address;
}
