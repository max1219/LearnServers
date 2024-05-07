package org.ogr.gor.www.old.server;

import org.ogr.gor.www.old.updated.controllers.StudentController;
import org.ogr.gor.www.old.updated.controllers.StudentGroupController;
import org.ogr.gor.www.old.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.students.*;
import org.ogr.gor.www.old.entities.responses.ResponseEntity;
import org.ogr.gor.www.old.exceptions.other_exceptions.JsonException;
import org.ogr.gor.www.old.jsonMapper.IJsonMapper;

import java.util.ArrayList;
import java.util.Collections;

public class Server {
    private final IJsonMapper mapper;
    private final StudentController studentController;
    private final StudentGroupController studentGroupController;

    public Server(IJsonMapper mapper, StudentController studentController, StudentGroupController studentGroupController) {
        this.mapper = mapper;
        this.studentController = studentController;
        this.studentGroupController = studentGroupController;
    }

    public ResponseEntity<?> process(String endPoint, String json) {
        try {
            switch (endPoint) {
                case "getStudentGroups":
                    return studentGroupController.getStudentsGroups();
                case "getStudentGroupById":
                    return studentGroupController.getStudentGroupById(mapper.map(GetStudentGroupRequest.class, json));
                case "addStudentGroup":
                    return studentGroupController.addStudentGroup(mapper.map(AddStudentGroupRequest.class, json));
                case "editStudentGroup":
                    return studentGroupController.editStudentGroup(mapper.map(EditStudentGroupRequest.class, json));
                case "deleteStudentGroup":
                    return studentGroupController.deleteStudentGroup(mapper.map(DeleteStudentGroupRequest.class, json));
                case "getStudentsByGroup":
                    return studentController.getStudentsByGroup(mapper.map(GetStudentsByGroupRequest.class, json));
                case "getStudentById":
                    return studentController.getStudentById(mapper.map(GetStudentByIdRequest.class, json));
                case "addStudent":
                    return studentController.addStudent(mapper.map(AddStudentRequest.class, json));
                case "editStudent":
                    return studentController.editStudent(mapper.map(EditStudentRequest.class, json));
                case "deleteStudent":
                    return studentController.deleteStudent(mapper.map(DeleteStudentRequest.class, json));
                case "getTeachers":
                    break;
                case "getTeacherById":
                    break;
                case "addTeacher":
                    break;
                case "editTeacher":
                    break;
                case "deleteTeacher":
                    break;
                case "getSubjects":
                    break;
                case "getSubjectById":
                    break;
                case "addSubject":
                    break;
                case "editSubject":
                    break;
                case "deleteSubject":
                    break;
                case "getLessonsByGroup":
                    break;
                case "getLessonsByTeacher":
                    break;
                case "getLessonById":
                    break;
                case "addLesson":
                    break;
                case "editLesson":
                    break;
                case "deleteLesson":
                    break;
                case "getAttendance":
                    break;
                case "setAttendance":
                    break;

            }
        } catch (JsonException e) {
            return new ResponseEntity<Void>(null, (short) 400, new ArrayList<>(Collections.singleton("Json некорректен")));
        }
        catch (Exception e) {
            return new ResponseEntity<Void>(null, (short) 422, new ArrayList<>(Collections.singleton(e.getMessage())));
        }
        return new ResponseEntity<Void>(null, (short) 400, new ArrayList<>(Collections.singleton("Неверное имя метода")));
    }
}
