package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.database.Teacher;
import org.ogr.gor.www.entities.requests.teachers.AddTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.DeleteTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.EditTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.GetTeacherByIdRequest;
import org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.service_exceptions.NotFoundException;

public interface ITeacherService {
    Teacher[] getTeachers();

    Teacher getTeacherById(GetTeacherByIdRequest request) throws NotFoundException;

    long addTeacher(AddTeacherRequest request) throws NotEnoughMemoryException;

    void editTeacher(EditTeacherRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteTeacher(DeleteTeacherRequest request) throws NotFoundException;
}
