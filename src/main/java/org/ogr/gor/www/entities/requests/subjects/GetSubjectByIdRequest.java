package org.ogr.gor.www.entities.requests.subjects;

public class GetSubjectByIdRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetSubjectByIdRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
