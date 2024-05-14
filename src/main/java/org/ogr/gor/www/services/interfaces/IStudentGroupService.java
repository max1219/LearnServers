package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.updated.entities.database.StudentGroup;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;

public interface IStudentGroupService {
    StudentGroup[] getStudentGroups();

    StudentGroup getStudentGroupById(GetStudentGroupRequest request) throws NotFoundException;

    long addStudentGroup(AddStudentGroupRequest request) throws NotEnoughMemoryException;

    void editStudentGroup(EditStudentGroupRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteStudentGroup(DeleteStudentGroupRequest request) throws NotFoundException;
}
