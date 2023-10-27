package services.interfaces;

import entities.requests.student_groups.AddStudentGroupRequest;
import entities.requests.student_groups.DeleteStudentGroupRequest;
import entities.requests.student_groups.EditStudentGroupRequest;
import entities.requests.student_groups.GetStudentGroupRequest;
import entities.responses.student_groups.AddStudentGroupResponse;
import entities.responses.student_groups.GetStudentGroupResponse;

import java.util.List;

public interface IStudentGroupService {
    List<GetStudentGroupResponse> getStudentsGroups();

    GetStudentGroupResponse getStudentGroupById(GetStudentGroupRequest request);

    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request);

    void editStudentGroup(EditStudentGroupRequest request);

    void deleteStudentGroup(DeleteStudentGroupRequest request);
}
