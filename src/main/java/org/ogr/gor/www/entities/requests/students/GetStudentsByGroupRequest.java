package org.ogr.gor.www.entities.requests.students;

import javax.validation.constraints.PositiveOrZero;

public class GetStudentsByGroupRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetStudentsByGroupRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetStudentsByGroupRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
