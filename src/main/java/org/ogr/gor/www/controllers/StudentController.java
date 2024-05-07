package org.ogr.gor.www.controllers;

import org.ogr.gor.www.old.entities.database.Student;
import org.ogr.gor.www.entities.requests.students.*;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class StudentController {
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    // todo Задуматься над переделкой под ResponseEntity для возвращения списка ошибок
    @GetMapping("/students/fromGroup/{request}")
    public Student[] getStudentsByGroup(@PathVariable GetStudentsByGroupRequest request) {
        try {
            return studentService.getStudentsByGroup(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/students/{request}")
    public Student getStudentById(@PathVariable GetStudentByIdRequest request) {
        try {
            return studentService.getStudentById(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping("/students/add")
    public long addStudent(@RequestBody AddStudentRequest request) {
        try {
            return studentService.addStudent(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/students/edit")
    public void editStudent(@RequestBody EditStudentRequest request) {
        try {
            studentService.editStudent(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/students/delete")
    public void deleteStudent(@RequestParam DeleteStudentRequest id) {
        try {
            studentService.deleteStudent(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
