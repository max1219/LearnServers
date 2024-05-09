package org.ogr.gor.www.entities.requests.teachers;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class EditTeacherRequest {
    @PositiveOrZero
    private final long id;

    @NotEmpty
    @Size(max = 30)
    private final String lastName;

    @NotEmpty
    @Size(max = 30)
    private final String firstName;

    @NotEmpty
    @Size(max = 30)
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
