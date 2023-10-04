package entities;

public class Student {
    private final Long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String groupId;
    private final String status;

    public Student(Long id, String lastName, String firstName, String middleName, String groupId, String status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }

    public Long getId() {
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

    public String getGroupId() {
        return groupId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
