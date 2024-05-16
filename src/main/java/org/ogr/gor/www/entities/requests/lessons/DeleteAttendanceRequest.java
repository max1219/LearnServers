package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.PositiveOrZero;

public class DeleteAttendanceRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteAttendanceRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
