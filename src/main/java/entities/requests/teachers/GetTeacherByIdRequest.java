package entities.requests.teachers;

public class GetTeacherByIdRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
