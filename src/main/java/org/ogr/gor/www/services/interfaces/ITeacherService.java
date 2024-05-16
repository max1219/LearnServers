package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.database.StudentGroup;
import org.ogr.gor.www.entities.database.Teacher;
import org.ogr.gor.www.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.entities.requests.teachers.AddTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.DeleteTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.EditTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.GetTeacherByIdRequest;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;

public interface ITeacherService {
    Teacher[] getTeachers();

    Teacher getTeacherById(GetTeacherByIdRequest request) throws NotFoundException;

    long addTeacher(AddTeacherRequest request) throws NotEnoughMemoryException;

    void editTeacher(EditTeacherRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteTeacher(DeleteTeacherRequest request) throws NotFoundException;
}
