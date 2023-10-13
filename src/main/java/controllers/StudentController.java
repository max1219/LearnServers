package controllers;

import entities.requests.students.*;
import entities.responses.ResponseEntity;
import entities.responses.students.AddStudentResponse;
import entities.responses.students.GetStudentResponse;
import validators.requests.students.*;

import java.util.List;

public class StudentController {
    private final AddStudentRequestValidator addStudentRequestValidator;
    private final DeleteStudentRequestValidator deleteStudentRequestValidator;
    private final EditStudentRequestValidator editStudentRequestValidator;
    private final GetStudentByIdRequestValidator getStudentByIdRequestValidator;
    private final GetStudentsByGroupRequestValidator getStudentsByGroupRequestValidator;

    public StudentController(AddStudentRequestValidator addStudentRequestValidator, DeleteStudentRequestValidator deleteStudentRequestValidator, EditStudentRequestValidator editStudentRequestValidator, GetStudentByIdRequestValidator getStudentByIdRequestValidator, GetStudentsByGroupRequestValidator getStudentsByGroupRequestValidator) {
        this.addStudentRequestValidator = addStudentRequestValidator;
        this.deleteStudentRequestValidator = deleteStudentRequestValidator;
        this.editStudentRequestValidator = editStudentRequestValidator;
        this.getStudentByIdRequestValidator = getStudentByIdRequestValidator;
        this.getStudentsByGroupRequestValidator = getStudentsByGroupRequestValidator;
    }

    public ResponseEntity<List<GetStudentResponse>> getStudentsByGroup(GetStudentsByGroupRequest request){
        List<String> errors = getStudentsByGroupRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<List<GetStudentResponse>> getStudentById(GetStudentByIdRequest request){
        List<String> errors = getStudentByIdRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<List<AddStudentResponse>> addStudent(AddStudentRequest request){
        List<String> errors = addStudentRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<List<Void>> editStudent(EditStudentRequest request){
        List<String> errors = editStudentRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }

    public ResponseEntity<List<Void>> deleteStudent(DeleteStudentRequest request){
        List<String> errors = deleteStudentRequestValidator.validate(request);
        if (!errors.isEmpty()) {
            return new ResponseEntity<>(null, (short) 400);
        }
        return new ResponseEntity<>(null, (short) 200);
    }
}
