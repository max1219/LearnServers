package org.ogr.gor.www.entities.requests.teachers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddTeacherRequest {
    @NotEmpty
    @Size(max = 30)
    private final String lastName;

    @NotEmpty
    @Size(max = 30)
    private final String firstName;

    @NotEmpty
    @Size(max = 30)
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
