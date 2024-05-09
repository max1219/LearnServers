package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

public class SetAttendanceRequest {

    @PositiveOrZero
    private final long lessonId;

    private final List<@PositiveOrZero @NotNull Long> visitedId;


    @java.beans.ConstructorProperties({"lessonId", "visitedId"})
    public SetAttendanceRequest(long lessonId, List<Long> visitedId) {
        this.lessonId = lessonId;
        this.visitedId = visitedId;
    }

    public long getLessonId() {
        return lessonId;
    }

    public List<Long> getVisitedId() {
        return visitedId;
    }
}
