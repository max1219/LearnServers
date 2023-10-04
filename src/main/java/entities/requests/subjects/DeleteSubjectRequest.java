package entities.requests.subjects;

public class DeleteSubjectRequest {
    private final long id;

    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DeleteSubjectRequest(" + id + ")";
    }
}
