package entities.responses.teachers;

public class GetTeacherResponse {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;

    public GetTeacherResponse(long id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
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
}
