package org.ogr.gor.www.controllers;

import org.ogr.gor.www.entities.database.Subject;
import org.ogr.gor.www.entities.requests.subjects.AddSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.DeleteSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.EditSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.GetSubjectByIdRequest;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.ISubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@Validated
public class SubjectController {

    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @GetMapping("/subjects")
    public Subject[] getSubjects() {
        try {
            return subjectService.getSubjects();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @GetMapping("/subjects/{request}")
    public Subject getSubjectById(@PathVariable @Valid GetSubjectByIdRequest request) {
        try {
            return subjectService.getSubjectById(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PostMapping("/subjects/add")
    public long addSubject(@RequestBody @Valid AddSubjectRequest request) {
        try {
            return subjectService.addSubject(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @PutMapping("/subjects/edit")
    public void editSubject(@RequestBody @Valid EditSubjectRequest request) {
        try {
            subjectService.editSubject(request);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }

    @DeleteMapping("/subjects/delete")
    public void deleteSubject(@RequestParam @Valid DeleteSubjectRequest id) {
        try {
            subjectService.deleteSubject(id);
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }
    }
}