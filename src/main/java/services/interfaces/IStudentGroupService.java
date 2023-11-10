package services.interfaces;

import entities.requests.student_groups.AddStudentGroupRequest;
import entities.requests.student_groups.DeleteStudentGroupRequest;
import entities.requests.student_groups.EditStudentGroupRequest;
import entities.requests.student_groups.GetStudentGroupRequest;
import entities.responses.student_groups.AddStudentGroupResponse;
import entities.responses.student_groups.GetStudentGroupResponse;
import exceptions.service_exceptions.NotEnoughMemoryException;
import exceptions.service_exceptions.NotFoundException;

import java.util.List;

public interface IStudentGroupService {
    List<GetStudentGroupResponse> getStudentGroups();

    GetStudentGroupResponse getStudentGroupById(GetStudentGroupRequest request) throws NotFoundException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotEnoughMemoryException;

    void editStudentGroup(EditStudentGroupRequest request) throws NotFoundException, NotEnoughMemoryException;

    void deleteStudentGroup(DeleteStudentGroupRequest request) throws NotFoundException;
}
