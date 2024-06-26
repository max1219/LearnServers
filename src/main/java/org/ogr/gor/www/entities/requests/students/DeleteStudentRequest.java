package org.ogr.gor.www.entities.requests.students;

import javax.validation.constraints.PositiveOrZero;

public class DeleteStudentRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public DeleteStudentRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
