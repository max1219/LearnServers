package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.PositiveOrZero;

public class GetAttendanceRequest {
    @PositiveOrZero
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetAttendanceRequest(long id) {
        this.id = id;
    }

    @java.beans.ConstructorProperties({"id"})
    public GetAttendanceRequest(String id) {
        this.id = Long.parseLong(id);
    }
    public long getId() {
        return id;
    }
}
