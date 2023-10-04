package entities.requests.subjects;

public class GetSubjectByIdRequest {
    private final long id;

    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GetSubjectByIdRequest(" + id + ")";
    }
}
