package org.ogr.gor.www.entities.requests.subjects;

import javax.validation.constraints.PositiveOrZero;

public class DeleteSubjectRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public DeleteSubjectRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
