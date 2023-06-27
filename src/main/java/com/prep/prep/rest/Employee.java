package com.prep.prep.rest;


import com.prep.prep.dto.StudentDTO;
import com.prep.prep.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/University")
public class Employee {
    @Autowired
    StudentServiceImpl studentService;
    @PostMapping("/Student")
    public ResponseEntity<String> insert(@RequestBody StudentDTO studentDTO){
        studentService.save(studentDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/Student")
    public ResponseEntity<List<StudentDTO>> get(){
        return  ResponseEntity.accepted().body(studentService.get());
    }
    @GetMapping("/Student/{id}")
    public ResponseEntity<List<StudentDTO>> getById(@PathVariable Integer id){
        return ResponseEntity.accepted().body(studentService.get(id)) ;
    }
}
