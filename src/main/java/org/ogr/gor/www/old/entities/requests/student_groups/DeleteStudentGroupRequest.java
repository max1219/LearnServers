package org.ogr.gor.www.old.entities.requests.student_groups;

public class DeleteStudentGroupRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteStudentGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
