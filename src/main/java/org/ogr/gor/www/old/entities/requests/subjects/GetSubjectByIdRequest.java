package org.ogr.gor.www.old.entities.requests.subjects;

public class GetSubjectByIdRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
