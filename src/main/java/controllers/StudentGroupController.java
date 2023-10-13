package controllers;

import entities.requests.student_groups.AddStudentGroupRequest;
import entities.requests.student_groups.DeleteStudentGroupRequest;
import entities.requests.student_groups.EditStudentGroupRequest;
import entities.requests.student_groups.GetStudentGroupRequest;
import entities.responses.ResponseEntity;
import entities.responses.student_groups.AddStudentGroupResponse;
import entities.responses.student_groups.GetStudentGroupResponse;
import validators.requests.student_groups.AddStudentGroupRequestValidator;
import validators.requests.student_groups.DeleteStudentGroupRequestValidator;
import validators.requests.student_groups.EditStudentGroupRequestValidator;
import validators.requests.student_groups.GetStudentGroupRequestValidator;

import java.util.List;

public class StudentGroupController {
    private final AddStudentGroupRequestValidator addStudentGroupRequestValidator;
    private final DeleteStudentGroupRequestValidator deleteStudentGroupRequestValidator;
    private final EditStudentGroupRequestValidator editStudentGroupRequestValidator;
    private final GetStudentGroupRequestValidator getStudentGroupRequestValidator;

    public StudentGroupController(AddStudentGroupRequestValidator addStudentGroupRequestValidator, DeleteStudentGroupRequestValidator deleteStudentGroupRequestValidator, EditStudentGroupRequestValidator editStudentGroupRequestValidator, GetStudentGroupRequestValidator getStudentGroupRequestValidator) {
        this.addStudentGroupRequestValidator = addStudentGroupRequestValidator;
        this.deleteStudentGroupRequestValidator = deleteStudentGroupRequestValidator;
        this.editStudentGroupRequestValidator = editStudentGroupRequestValidator;
        this.getStudentGroupRequestValidator = getStudentGroupRequestValidator;
    }

    public ResponseEntity<List<GetStudentGroupResponse>> getStudentsGroups() {
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<GetStudentGroupResponse> getStudentGroupById(GetStudentGroupRequest request) {
        List<String> errors = getStudentGroupRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<AddStudentGroupResponse> addStudentGroup(AddStudentGroupRequest request) {
        List<String> errors = addStudentGroupRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<Void> editStudentGroup(EditStudentGroupRequest request) {
        List<String> errors = editStudentGroupRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<Void> deleteStudentGroup(DeleteStudentGroupRequest request) {
        List<String> errors = deleteStudentGroupRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

}
