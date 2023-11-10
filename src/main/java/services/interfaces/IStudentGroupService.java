package services.interfaces;

import entities.requests.student_groups.AddStudentGroupRequest;
import entities.requests.student_groups.DeleteStudentGroupRequest;
import entities.requests.student_groups.EditStudentGroupRequest;
import entities.requests.student_groups.GetStudentGroupRequest;
import entities.responses.student_groups.AddStudentGroupResponse;
import entities.responses.student_groups.GetStudentGroupResponse;
import exceptions.service_exceptions.ServiceException;

import java.util.List;

public interface IStudentGroupService {
    List<GetStudentGroupResponse> getStudentGroups() throws ServiceException;

    GetStudentGroupResponse getStudentGroupById(GetStudentGroupRequest request) throws ServiceException;

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws ServiceException;

    void editStudentGroup(EditStudentGroupRequest request) throws ServiceException;

    void deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException;
}
