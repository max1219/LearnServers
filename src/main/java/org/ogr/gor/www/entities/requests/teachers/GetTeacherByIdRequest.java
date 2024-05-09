package org.ogr.gor.www.entities.requests.teachers;

import javax.validation.constraints.PositiveOrZero;

public class GetTeacherByIdRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetTeacherByIdRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
