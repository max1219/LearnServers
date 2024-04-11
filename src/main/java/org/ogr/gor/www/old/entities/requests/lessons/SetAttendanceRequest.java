package org.ogr.gor.www.old.entities.requests.lessons;

public class SetAttendanceRequest {

    private final long lessonId;
    private final long[] visitedId;

    @java.beans.ConstructorProperties({"lessonId", "visitedId"})
    public SetAttendanceRequest(long lessonId, long[] visitedId) {
        this.lessonId = lessonId;
        this.visitedId = visitedId;
    }

    public long getLessonId() {
        return lessonId;
    }

    public long[] getVisitedId() {
        return visitedId;
    }
}
