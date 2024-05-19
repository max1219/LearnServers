package org.ogr.gor.www.controllers;

import org.ogr.gor.www.entities.database.Student;
import org.ogr.gor.www.entities.requests.students.*;
import org.ogr.gor.www.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@Validated
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    // todo Задуматься над переделкой под ResponseEntity для возвращения списка ошибок
    @GetMapping("/students/byGroup/{request}")
    public Student[] getStudentsByGroup(@PathVariable @Valid GetStudentsByGroupRequest request) {
        try {
            return studentService.getStudentsByGroup(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @GetMapping("/students/{request}")
    public Student getStudentById(@PathVariable @Valid GetStudentByIdRequest request) {
        try {
            return studentService.getStudentById(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PostMapping("/students/add")
    public long addStudent(@RequestBody @Valid AddStudentRequest request) {
        try {
            return studentService.addStudent(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PutMapping("/students/edit")
    public void editStudent(@RequestBody @Valid EditStudentRequest request) {
        try {
            studentService.editStudent(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @DeleteMapping("/students/delete")
    public void deleteStudent(@RequestParam @Valid DeleteStudentRequest id) {
        try {
            studentService.deleteStudent(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }
}
