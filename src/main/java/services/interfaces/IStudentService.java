package services.interfaces;

import entities.requests.students.*;
import entities.responses.students.AddStudentResponse;
import entities.responses.students.GetStudentResponse;

import java.util.List;

public interface IStudentService {
    List<GetStudentResponse> getStudentsByGroup(GetStudentsByGroupRequest request);

    GetStudentResponse getStudentsById(GetStudentByIdRequest request);

    AddStudentResponse addStudent(AddStudentRequest request);

    void editStudent(EditStudentRequest request);

    void deleteStudent(DeleteStudentRequest request);
}
