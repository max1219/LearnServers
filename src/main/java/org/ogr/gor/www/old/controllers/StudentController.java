package org.ogr.gor.www.old.controllers;

import org.ogr.gor.www.old.entities.requests.students.*;
import org.ogr.gor.www.old.entities.responses.ResponseEntity;
import org.ogr.gor.www.old.entities.responses.students.AddStudentResponse;
import org.ogr.gor.www.old.entities.responses.students.GetStudentResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.services.interfaces.IStudentService;
import org.ogr.gor.www.old.validators.requests.students.*;

import java.util.Collections;
import java.util.List;

public class StudentController {
    private final IStudentService studentService;
    private final AddStudentRequestValidator addStudentRequestValidator;
    private final DeleteStudentRequestValidator deleteStudentRequestValidator;
    private final EditStudentRequestValidator editStudentRequestValidator;
    private final GetStudentByIdRequestValidator getStudentByIdRequestValidator;
    private final GetStudentsByGroupRequestValidator getStudentsByGroupRequestValidator;

    public StudentController(IStudentService studentService, AddStudentRequestValidator addStudentRequestValidator, DeleteStudentRequestValidator deleteStudentRequestValidator, EditStudentRequestValidator editStudentRequestValidator, GetStudentByIdRequestValidator getStudentByIdRequestValidator, GetStudentsByGroupRequestValidator getStudentsByGroupRequestValidator) {
        this.studentService = studentService;
        this.addStudentRequestValidator = addStudentRequestValidator;
        this.deleteStudentRequestValidator = deleteStudentRequestValidator;
        this.editStudentRequestValidator = editStudentRequestValidator;
        this.getStudentByIdRequestValidator = getStudentByIdRequestValidator;
        this.getStudentsByGroupRequestValidator = getStudentsByGroupRequestValidator;
    }

    public ResponseEntity<List<GetStudentResponse>> getStudentsByGroup(GetStudentsByGroupRequest request) {
        try {
            List<String> errors = getStudentsByGroupRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }

            List<GetStudentResponse> response = studentService.getStudentsByGroup(request);
            return new ResponseEntity<>(response, (short) 200, null);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<GetStudentResponse> getStudentById(GetStudentByIdRequest request) {
        try {
            List<String> errors = getStudentByIdRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }
            try {
                GetStudentResponse response = studentService.getStudentById(request);
                return new ResponseEntity<>(response, (short) 200, null);
            } catch (NotFoundException ex) {
                return new ResponseEntity<>(null, (short) 404, Collections.singletonList(ex.getMessage()));
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<AddStudentResponse> addStudent(AddStudentRequest request) {
        try {
            List<String> errors = addStudentRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }

            AddStudentResponse response = studentService.addStudent(request);
            return new ResponseEntity<>(response, (short) 200, null);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<Void> editStudent(EditStudentRequest request) {
        try {
            List<String> errors = editStudentRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }
            try {
                studentService.editStudent(request);
                return new ResponseEntity<>(null, (short) 200, null);
            } catch (NotFoundException ex) {
                return new ResponseEntity<>(null, (short) 404, Collections.singletonList(ex.getMessage()));
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<Void> deleteStudent(DeleteStudentRequest request) {
        try {
            List<String> errors = deleteStudentRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }
            try {
                studentService.deleteStudent(request);
                return new ResponseEntity<>(null, (short) 200, null);
            } catch (NotFoundException ex) {
                return new ResponseEntity<>(null, (short) 404, Collections.singletonList(ex.getMessage()));
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }
}
