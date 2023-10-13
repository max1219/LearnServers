package entities.requests.attendances;

public class DeleteAttendanceRequest {
    private final long id;

    public DeleteAttendanceRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
