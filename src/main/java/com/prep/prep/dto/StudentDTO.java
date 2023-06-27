package com.prep.prep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private String address;
}
