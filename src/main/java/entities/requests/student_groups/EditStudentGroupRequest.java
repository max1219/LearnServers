package entities.requests.student_groups;

public class EditStudentGroupRequest {
    private final long id;
    private final String newName;

    public EditStudentGroupRequest(long id, String newName) {
        this.id = id;
        this.newName = newName;
    }

    public long getId() {
        return id;
    }

    public String getNewName() {
        return newName;
    }
}
