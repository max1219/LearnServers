package entities.requests.students;

public class DeleteStudentRequest {
    private final long id;

    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DeleteStudentRequest(" + id + ")";
    }
}
