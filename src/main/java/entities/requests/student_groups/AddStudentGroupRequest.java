package entities.requests.student_groups;

public class AddStudentGroupRequest {
    private final String name;

    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AddStudentGroupRequest(" + name + ")";
    }
}
