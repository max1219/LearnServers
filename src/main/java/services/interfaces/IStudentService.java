package services.interfaces;

import entities.requests.students.*;
import entities.responses.students.AddStudentResponse;
import entities.responses.students.GetStudentResponse;
import exceptions.service_exceptions.ServiceException;

import java.util.List;

public interface IStudentService {
    List<GetStudentResponse> getStudentsByGroup(GetStudentsByGroupRequest request) throws ServiceException;

    GetStudentResponse getStudentsById(GetStudentByIdRequest request) throws ServiceException;

    AddStudentResponse addStudent(AddStudentRequest request) throws ServiceException;

    void editStudent(EditStudentRequest request) throws ServiceException;

    void deleteStudent(DeleteStudentRequest request) throws ServiceException;
}
