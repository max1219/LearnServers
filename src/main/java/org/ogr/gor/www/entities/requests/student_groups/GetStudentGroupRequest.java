package org.ogr.gor.www.entities.requests.student_groups;

import javax.validation.constraints.PositiveOrZero;

public class GetStudentGroupRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetStudentGroupRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetStudentGroupRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
