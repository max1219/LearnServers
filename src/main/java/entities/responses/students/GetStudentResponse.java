package entities.responses.students;

public class GetStudentResponse {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final long groupId;
    private final String status;

    public GetStudentResponse(long id, String lastName, String firstName, String middleName, long groupId, String status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }

    public long getId() {
        return id;
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

    public long getGroupId() {
        return groupId;
    }

    public String getStatus() {
        return status;
    }
}
