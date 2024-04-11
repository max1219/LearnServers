package org.ogr.gor.www.old.services.interfaces;

import org.ogr.gor.www.old.entities.responses.students.AddStudentResponse;
import org.ogr.gor.www.old.entities.responses.students.GetStudentResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.entities.requests.students.*;

import java.util.List;

public interface IStudentService {
    List<GetStudentResponse> getStudentsByGroup(GetStudentsByGroupRequest request);

    GetStudentResponse getStudentById(GetStudentByIdRequest request) throws NotFoundException;

    AddStudentResponse addStudent(AddStudentRequest request) throws NotEnoughMemoryException;

    void editStudent(EditStudentRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteStudent(DeleteStudentRequest request) throws NotFoundException;
}
