package entities.requests.subjects;

public class GetSubjectByIdRequest {
    private final long id;

    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
