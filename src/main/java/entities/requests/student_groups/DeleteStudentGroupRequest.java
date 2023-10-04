package entities.requests.student_groups;

public class DeleteStudentGroupRequest {
    private final long id;

    public DeleteStudentGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
