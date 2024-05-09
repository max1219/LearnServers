package org.ogr.gor.www.entities.requests.students;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class EditStudentRequest {
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

    @PositiveOrZero
    private final long groupId;

    @NotEmpty
    @Size(max = 30)
    private final String status;

    @java.beans.ConstructorProperties({"id", "lastName", "firstName", "middleName", "groupId", "status"})
    public EditStudentRequest(long id, String lastName, String firstName, String middleName, long groupId, String status) {
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
