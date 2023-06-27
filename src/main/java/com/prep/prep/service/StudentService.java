package com.prep.prep.service;

import com.prep.prep.dto.StudentDTO;

import java.util.List;

interface  StudentService {

    public void save(StudentDTO studentDTO);
    public List<StudentDTO> get();
    public List<StudentDTO> get(Integer id);
}
