package org.ogr.gor.www.entities.requests.student_groups;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class EditStudentGroupRequest {
    @PositiveOrZero
    private final long id;

    @NotEmpty
    @Size(max = 30)
    private final String name;

    @java.beans.ConstructorProperties({"id", "name"})
    public EditStudentGroupRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
