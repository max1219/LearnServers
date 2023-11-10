package services.interfaces;

import entities.requests.students.*;
import entities.responses.students.AddStudentResponse;
import entities.responses.students.GetStudentResponse;
import exceptions.service_exceptions.NotEnoughMemoryException;
import exceptions.service_exceptions.NotFoundException;

import java.util.List;

public interface IStudentService {
    List<GetStudentResponse> getStudentsByGroup(GetStudentsByGroupRequest request);

    GetStudentResponse getStudentsById(GetStudentByIdRequest request) throws NotFoundException;

    AddStudentResponse addStudent(AddStudentRequest request) throws NotEnoughMemoryException;

    void editStudent(EditStudentRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteStudent(DeleteStudentRequest request) throws NotFoundException;
}
