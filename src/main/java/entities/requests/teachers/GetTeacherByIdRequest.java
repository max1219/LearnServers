package entities.requests.teachers;

public class GetTeacherByIdRequest {
    private final long id;

    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GetTeacherByIdRequest(" + id + ")";
    }
}
