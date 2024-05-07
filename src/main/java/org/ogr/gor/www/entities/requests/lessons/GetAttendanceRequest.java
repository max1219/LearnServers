package org.ogr.gor.www.entities.requests.lessons;

public class GetAttendanceRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public GetAttendanceRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
