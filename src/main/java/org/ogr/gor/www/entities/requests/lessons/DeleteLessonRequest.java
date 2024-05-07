package org.ogr.gor.www.entities.requests.lessons;

public class DeleteLessonRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteLessonRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public DeleteLessonRequest(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}
