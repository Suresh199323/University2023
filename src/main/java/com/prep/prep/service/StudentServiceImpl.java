package com.prep.prep.service;


import com.prep.prep.dto.StudentDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl {
    /*@Autowired
    StudentRepository studentRepository;*/
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("scoppJDBCTemplate")
    JdbcTemplate scoppTemplate;

 /*   @Override
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
    }*/

  /*  @Override
    public List<StudentDTO> get(Integer id) {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        Optional<StudentEntity> byId = studentRepository.findById(id);
        if (byId.isPresent()) {
            studentDTOS = byId.stream().map(studentEntity -> new StudentDTO(studentEntity.getId(), studentEntity.getName(), studentEntity.getAddress()
            )).collect(Collectors.toList());
        }
        return studentDTOS;
    }*/

    public int  cool() throws ParseException {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        String date_string = "26-09-2012";

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        java.util.Date date = formatter.parse(date_string);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());


        System.out.println("Formatted SQL Date: " + sqlDate);

        int rows4 = scoppTemplate.update("UPDATE student SET id =991 , birthdate = '"+sqlDate+"'");

        System.out.println(rows4);
        return rows4;
    }
}
