package org.ogr.gor.www.old.entities.requests.lessons;

public class GetLessonByIdRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
