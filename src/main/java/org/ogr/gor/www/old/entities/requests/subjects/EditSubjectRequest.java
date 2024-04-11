package org.ogr.gor.www.old.entities.requests.subjects;

public class EditSubjectRequest {
    private final long id;
    private final String name;

    @java.beans.ConstructorProperties({"id", "name"})
    public EditSubjectRequest(long id, String name) {
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
