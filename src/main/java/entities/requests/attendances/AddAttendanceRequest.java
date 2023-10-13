package entities.requests.attendances;

public class AddAttendanceRequest {
    private final long lessonId;
    private final long[] visitedId;

    public AddAttendanceRequest(long lessonId, long[] visitedId) {
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
