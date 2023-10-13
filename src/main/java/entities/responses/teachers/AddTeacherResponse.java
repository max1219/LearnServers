package entities.responses.teachers;

public class AddTeacherResponse {
    private final long id;

    public AddTeacherResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
