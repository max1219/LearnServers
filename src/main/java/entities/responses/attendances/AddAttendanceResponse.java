package entities.responses.attendances;

public class AddAttendanceResponse {
    private final long id;

    public AddAttendanceResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
