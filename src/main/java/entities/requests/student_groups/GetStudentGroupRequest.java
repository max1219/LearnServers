package entities.requests.student_groups;

public class GetStudentGroupRequest {
    private final long id;

    public GetStudentGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
