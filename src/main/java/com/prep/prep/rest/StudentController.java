package com.prep.prep.rest;

import com.prep.prep.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/University")
public class StudentController {
    private StudentServiceImpl studentService;

    @PostMapping("/student")
    public ResponseEntity<Integer> insert() throws ParseException {
        //int cool = studentService.cool();
        log.info("Student*********");
        return new ResponseEntity<>(studentService.cool(),HttpStatus.ACCEPTED);
    }
}
