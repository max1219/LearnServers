package org.ogr.gor.www.entities.requests.teachers;

public class AddTeacherRequest {
    private final String lastName;
    private final String firstName;
    private final String middleName;

    @java.beans.ConstructorProperties({"lastName", "firstName", "middleName"})
    public AddTeacherRequest(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
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
