package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

public class GetLessonsByGroupRequest {
    @NotNull
    @Pattern(regexp = "^\\d\\d[._\\- ]\\d\\d[._\\- ]\\d\\d\\d\\d$")
    private final String startDate;

    @NotNull
    @Pattern(regexp = "^\\d\\d[._\\- ]\\d\\d[._\\- ]\\d\\d\\d\\d$")
    private final String endDate;

    @PositiveOrZero
    private final long groupId;

    @java.beans.ConstructorProperties({"startDate", "endDate", "groupId"})
    public GetLessonsByGroupRequest(String startDate, String endDate, long groupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getGroupId() {
        return groupId;
    }
}
