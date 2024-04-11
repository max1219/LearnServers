package org.ogr.gor.www.old.entities.requests.student_groups;

public class AddStudentGroupRequest {
    private final String name;

    @java.beans.ConstructorProperties({"name"})
    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
