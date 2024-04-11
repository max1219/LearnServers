package org.ogr.gor.www.old.entities.requests.subjects;

public class AddSubjectRequest {
    private final String name;

    @java.beans.ConstructorProperties({"name"})
    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
