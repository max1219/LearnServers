package org.ogr.gor.www.old.entities.requests.teachers;

public class EditTeacherRequest {
    private final long id;
    private final String lastName;
    private final String firstName;
    private final String middleName;

    @java.beans.ConstructorProperties({"id", "lastName", "firstName", "middleName"})
    public EditTeacherRequest(long id, String lastName, String firstName, String middleName) {
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
