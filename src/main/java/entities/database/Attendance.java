package entities.database;

public class Attendance {
    private final Long id;
    private final long[] visitedId;

    public Attendance(Long id, long[] visitedId) {
        this.id = id;
        this.visitedId = visitedId;
    }

    public Long getId() {
        return id;
    }

    public long[] getVisitedId() {
        return visitedId;
    }
}
