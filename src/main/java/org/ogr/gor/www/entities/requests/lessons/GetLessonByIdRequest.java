package org.ogr.gor.www.entities.requests.lessons;

public class GetLessonByIdRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetLessonByIdRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
