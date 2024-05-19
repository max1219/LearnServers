package org.ogr.gor.www.controllers;

import org.ogr.gor.www.entities.database.Teacher;
import org.ogr.gor.www.entities.requests.teachers.AddTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.DeleteTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.EditTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.GetTeacherByIdRequest;
import org.ogr.gor.www.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.ITeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@Validated
public class TeacherController {
    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public Teacher[] getTeachers() {
        try {
            return teacherService.getTeachers();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @GetMapping("/teachers/{request}")
    public Teacher getTeacherById(@PathVariable @Valid GetTeacherByIdRequest request) {
        try {
            return teacherService.getTeacherById(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PostMapping("/teachers/add")
    public long addTeacher(@RequestBody @Valid AddTeacherRequest request) {
        try {
            return teacherService.addTeacher(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PutMapping("/teachers/edit")
    public void editTeacher(@RequestBody @Valid EditTeacherRequest request) {
        try {
            teacherService.editTeacher(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @DeleteMapping("/teachers/delete")
    public void deleteTeacher(@RequestParam @Valid DeleteTeacherRequest id) {
        try {
            teacherService.deleteTeacher(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }
}
