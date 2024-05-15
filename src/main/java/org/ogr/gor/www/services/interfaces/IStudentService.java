package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.requests.students.*;
import org.ogr.gor.www.entities.database.Student;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;

public interface IStudentService {
    Student[] getStudentsByGroup(GetStudentsByGroupRequest request);

    Student getStudentById(GetStudentByIdRequest request) throws NotFoundException;

    long addStudent(AddStudentRequest request) throws NotEnoughMemoryException;

    void editStudent(EditStudentRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteStudent(DeleteStudentRequest request) throws NotFoundException;
}
