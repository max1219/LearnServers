package org.ogr.gor.www.entities.requests.students;

import javax.validation.constraints.PositiveOrZero;

public class GetStudentByIdRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetStudentByIdRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
