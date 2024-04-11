package org.ogr.gor.www.old.entities.requests.teachers;

public class DeleteTeacherRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteTeacherRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
