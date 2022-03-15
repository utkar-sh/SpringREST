package com.utkarsh.programmingAssignment.controllers;

import com.google.inject.Inject;
import com.utkarsh.programmingAssignment.models.Student;
import com.utkarsh.programmingAssignment.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {
    private final StudentService studentService;

    @Inject
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> createNewStudent(Student student) {
        return studentService.createNewStudent(student);
    }

    @GetMapping
    public ResponseEntity<Object> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> editStudent(Student editedStudent) {
        return studentService.editStudent(editedStudent);
    }

    @GetMapping("/{schoolName}")
    public ResponseEntity<Object> getBySchooName(@PathVariable String schoolName) {

        return studentService.getBySchoolName(schoolName);
    }

}
