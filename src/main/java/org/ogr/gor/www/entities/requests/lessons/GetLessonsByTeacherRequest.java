package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class GetLessonsByTeacherRequest {
    @NotNull
    @Pattern(regexp = "^\\d\\d[._\\- ]\\d\\d[._\\- ]\\d\\d\\d\\d$")
    private final String startDate;

    @NotNull
    @Pattern(regexp = "^\\d\\d[._\\- ]\\d\\d[._\\- ]\\d\\d\\d\\d$")
    private final String endDate;

    @PositiveOrZero
    private final long teacherId;

    @java.beans.ConstructorProperties({"startDate", "endDate", "teacherId"})
    public GetLessonsByTeacherRequest(String startDate, String endDate, long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getTeacherId() {
        return teacherId;
    }
}
