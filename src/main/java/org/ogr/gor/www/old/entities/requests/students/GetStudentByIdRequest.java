package org.ogr.gor.www.old.entities.requests.students;

public class GetStudentByIdRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
