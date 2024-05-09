package org.ogr.gor.www.entities.requests.subjects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AddSubjectRequest {
    @NotEmpty
    @Size(max = 30)
    private final String name;

    @java.beans.ConstructorProperties({"name"})
    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
