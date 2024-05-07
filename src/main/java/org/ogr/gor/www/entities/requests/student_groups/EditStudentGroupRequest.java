package org.ogr.gor.www.entities.requests.student_groups;

public class EditStudentGroupRequest {
    private final long id;
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
