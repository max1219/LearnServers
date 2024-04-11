package org.ogr.gor.www.controllers;


import org.ogr.gor.www.old.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.entities.responses.ResponseEntity;
import org.ogr.gor.www.old.entities.responses.student_groups.AddStudentGroupResponse;
import org.ogr.gor.www.old.entities.responses.student_groups.GetStudentGroupResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.services.interfaces.IStudentGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

// todo Вытащить заголовок соответствующий
// todo Возвращает null в имени
@RestController
public class StudentGroupController {

    private final IStudentGroupService studentGroupService;

    public StudentGroupController(IStudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }


    @GetMapping("/studentGroups")
    public List<GetStudentGroupResponse> getStudentsGroups() {
        try {
            return studentGroupService.getStudentGroups();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "entity not found");
        }
    }

    @GetMapping("/studentGroups/{id}")
    public GetStudentGroupResponse getStudentGroupById(@PathVariable long id) {
        try {
            return studentGroupService.getStudentGroupById(new GetStudentGroupRequest(id));
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "entity not found");
        }
    }

    @PostMapping("/studentGroups/add")
    public AddStudentGroupResponse addStudentGroup(@RequestBody AddStudentGroupRequest request) {
        try {
            return studentGroupService.addStudentGroup(request);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "entity not found");
        }
    }
/*
    public void editStudentGroup(@RequestParam EditStudentGroupRequest request) {
        try {
            return studentGroupService.editStudentGroup(new GetStudentGroupRequest(id));
        } catch (NotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "entity not found");
        }

        try {
            List<String> errors = editStudentGroupRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }
            try {
                studentGroupService.editStudentGroup(request);
                return new ResponseEntity<>(null, (short) 200, null);
            } catch (NotFoundException ex) {
                return new ResponseEntity<>(null, (short) 404, Collections.singletonList(ex.getMessage()));
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<Void> deleteStudentGroup(DeleteStudentGroupRequest request) {
        try {
            List<String> errors = deleteStudentGroupRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }
            try {
                studentGroupService.deleteStudentGroup(request);
                return new ResponseEntity<>(null, (short) 200, null);
            } catch (NotFoundException ex) {
                return new ResponseEntity<>(null, (short) 404, Collections.singletonList(ex.getMessage()));
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }*/
}
