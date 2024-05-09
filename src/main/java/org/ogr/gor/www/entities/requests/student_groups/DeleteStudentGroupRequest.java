package org.ogr.gor.www.entities.requests.student_groups;

import javax.validation.constraints.PositiveOrZero;

public class DeleteStudentGroupRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteStudentGroupRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public DeleteStudentGroupRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
