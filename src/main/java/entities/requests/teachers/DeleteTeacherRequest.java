package entities.requests.teachers;

public class DeleteTeacherRequest {
    private final long id;

    public DeleteTeacherRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DeleteTeacherRequest(" + id + ")";
    }
}
