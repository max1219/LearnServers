package entities.requests.students;

public class DeleteStudentRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
