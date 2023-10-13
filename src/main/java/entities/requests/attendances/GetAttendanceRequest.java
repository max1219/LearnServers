package entities.requests.attendances;

public class GetAttendanceRequest {
    private final long id;

    public GetAttendanceRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
