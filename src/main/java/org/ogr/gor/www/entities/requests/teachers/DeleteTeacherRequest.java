package org.ogr.gor.www.entities.requests.teachers;

import javax.validation.constraints.PositiveOrZero;

public class DeleteTeacherRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteTeacherRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public DeleteTeacherRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
