package entities.requests.students;

public class GetStudentByIdRequest {
    private final long id;

    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GetStudentByIdRequest(" + id + ")";
    }
}
