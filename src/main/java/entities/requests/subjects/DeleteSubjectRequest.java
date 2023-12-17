package entities.requests.subjects;

public class DeleteSubjectRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
