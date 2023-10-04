package entities.requests.students;

public class AddStudentRequest {
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String groupId;
    private final String status;

    public AddStudentRequest(String lastName, String firstName, String middleName, String groupId, String status) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AddStudentRequest{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
