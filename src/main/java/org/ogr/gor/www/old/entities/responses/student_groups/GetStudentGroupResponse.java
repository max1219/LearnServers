package org.ogr.gor.www.old.entities.responses.student_groups;

public class GetStudentGroupResponse {
    private final String groupName;
    private final long id;

    public GetStudentGroupResponse(String groupName, long id) {
        this.groupName = groupName;
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public long getId() {
        return id;
    }
}
