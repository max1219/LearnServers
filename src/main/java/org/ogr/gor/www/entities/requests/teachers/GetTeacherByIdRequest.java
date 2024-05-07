package org.ogr.gor.www.entities.requests.teachers;

public class GetTeacherByIdRequest {
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
