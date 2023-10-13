package entities.requests.attendances;

public class EditAttendanceRequest {
    private final long id;
    private final long lessonId;
    private final long[] visitedId;

    public EditAttendanceRequest(long id, long lessonId, long[] visitedId) {
        this.id = id;
        this.lessonId = lessonId;
        this.visitedId = visitedId;
    }

    public long getId() {
        return id;
    }

    public long getLessonId() {
        return lessonId;
    }

    public long[] getVisitedId() {
        return visitedId;
    }
}
