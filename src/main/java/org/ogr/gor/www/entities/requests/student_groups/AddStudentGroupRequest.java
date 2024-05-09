package org.ogr.gor.www.entities.requests.student_groups;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddStudentGroupRequest {
    @NotEmpty
    @Size(max = 30)
    private final String name;

    @java.beans.ConstructorProperties({"name"})
    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
