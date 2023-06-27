package com.prep.prep.service;

import com.prep.prep.dto.StudentDTO;
import com.prep.prep.model.StudentEntity;
import com.prep.prep.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public void save(StudentDTO studentDTO) {

        StudentEntity studentEntity = modelMapper.map(studentDTO, StudentEntity.class);
        studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentDTO> get() {
        List<StudentEntity> all = studentRepository.findAll();
        List<StudentDTO> collect = all.stream().map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(),
                studentEntity.getAddress())).collect(Collectors.toList());

        return collect;
    }

    @Override
    public List<StudentDTO> get(Integer id) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            studentDTOS = byId.stream().map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAddress()
            )).collect(Collectors.toList());
        }
        return studentDTOS;
    }
}
