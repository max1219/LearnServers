package org.ogr.gor.www.controllers;


import org.ogr.gor.www.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.entities.database.StudentGroup;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.IStudentGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


// todo Вытащить заголовок соответствующий
// todo Возвращает null в имени

@RestController
@Validated
public class StudentGroupController {

    private final IStudentGroupService studentGroupService;

    public StudentGroupController(IStudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }


    @GetMapping("/studentGroups")
    public StudentGroup[] getStudentsGroups() {
        try {
            return studentGroupService.getStudentGroups();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @GetMapping("/studentGroups/{request}")
    public StudentGroup getStudentGroupById(@PathVariable @Valid GetStudentGroupRequest request) {
        try {
            return studentGroupService.getStudentGroupById(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    // todo controller advi(s/c)e

    @PostMapping("/studentGroups/add")
    public long addStudentGroup(@RequestBody @Valid AddStudentGroupRequest request) {
        try {
            return studentGroupService.addStudentGroup(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/studentGroups/edit")
    public void editStudentGroup(@RequestBody @Valid EditStudentGroupRequest request) {
        try {
            studentGroupService.editStudentGroup(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/studentGroups/delete")
    public void deleteStudentGroup(@RequestParam @Valid DeleteStudentGroupRequest id) {
        try {
            studentGroupService.deleteStudentGroup(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}