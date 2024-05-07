package org.ogr.gor.www.old.updated.services.interfaces;

import org.ogr.gor.www.old.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.entities.responses.student_groups.AddStudentGroupResponse;
import org.ogr.gor.www.old.entities.responses.student_groups.GetStudentGroupResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;

import java.util.List;

public interface IStudentGroupService {
    List<GetStudentGroupResponse> getStudentGroups();

    GetStudentGroupResponse getStudentGroupById(GetStudentGroupRequest request) throws NotFoundException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotEnoughMemoryException;

    void editStudentGroup(EditStudentGroupRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteStudentGroup(DeleteStudentGroupRequest request) throws NotFoundException;
}
