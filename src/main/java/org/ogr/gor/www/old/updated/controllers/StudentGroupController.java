package org.ogr.gor.www.old.updated.controllers;

import org.ogr.gor.www.old.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.entities.responses.ResponseEntity;
import org.ogr.gor.www.old.entities.responses.student_groups.AddStudentGroupResponse;
import org.ogr.gor.www.old.entities.responses.student_groups.GetStudentGroupResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.updated.services.interfaces.IStudentGroupService;
import org.ogr.gor.www.old.validators.requests.student_groups.AddStudentGroupRequestValidator;
import org.ogr.gor.www.old.validators.requests.student_groups.DeleteStudentGroupRequestValidator;
import org.ogr.gor.www.old.validators.requests.student_groups.EditStudentGroupRequestValidator;
import org.ogr.gor.www.old.validators.requests.student_groups.GetStudentGroupRequestValidator;

import java.util.Collections;
import java.util.List;

public class StudentGroupController {
    private final IStudentGroupService studentGroupService;
    private final AddStudentGroupRequestValidator addStudentGroupRequestValidator;
    private final DeleteStudentGroupRequestValidator deleteStudentGroupRequestValidator;
    private final EditStudentGroupRequestValidator editStudentGroupRequestValidator;
    private final GetStudentGroupRequestValidator getStudentGroupRequestValidator;

    public StudentGroupController(IStudentGroupService studentGroupService, AddStudentGroupRequestValidator addStudentGroupRequestValidator, DeleteStudentGroupRequestValidator deleteStudentGroupRequestValidator, EditStudentGroupRequestValidator editStudentGroupRequestValidator, GetStudentGroupRequestValidator getStudentGroupRequestValidator) {
        this.studentGroupService = studentGroupService;
        this.addStudentGroupRequestValidator = addStudentGroupRequestValidator;
        this.deleteStudentGroupRequestValidator = deleteStudentGroupRequestValidator;
        this.editStudentGroupRequestValidator = editStudentGroupRequestValidator;
        this.getStudentGroupRequestValidator = getStudentGroupRequestValidator;
    }

    public ResponseEntity<List<GetStudentGroupResponse>> getStudentsGroups() {
        try {
            List<GetStudentGroupResponse> response = studentGroupService.getStudentGroups();
            return new ResponseEntity<>(response, (short) 200, null);

        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<GetStudentGroupResponse> getStudentGroupById(GetStudentGroupRequest request) {
        try {
            List<String> errors = getStudentGroupRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }
            try {
                GetStudentGroupResponse response = studentGroupService.getStudentGroupById(request);
                return new ResponseEntity<>(response, (short) 200, null);
            } catch (NotFoundException ex) {
                return new ResponseEntity<>(null, (short) 404, Collections.singletonList(ex.getMessage()));
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<AddStudentGroupResponse> addStudentGroup(AddStudentGroupRequest request) {
        try {
            List<String> errors = addStudentGroupRequestValidator.validate(request);
            if (!errors.isEmpty()) {
                return new ResponseEntity<>(null, (short) 422, errors);
            }

            AddStudentGroupResponse id = studentGroupService.addStudentGroup(request);
            return new ResponseEntity<>(id, (short) 200, null);
            // NotEnoughMemory тоже 422, так что без отдельного try catch
        } catch (Exception ex) {
            return new ResponseEntity<>(null, (short) 422, Collections.singletonList(ex.getMessage()));
        }
    }

    public ResponseEntity<Void> editStudentGroup(EditStudentGroupRequest request) {
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
    }

}
