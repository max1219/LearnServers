package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class AddLessonRequest {
    @NotNull
    @Pattern(regexp = "^\\d\\d[._\\- ]\\d\\d[._\\- ]\\d\\d\\d\\d$")
    private final String date;

    @Positive
    private final int number;

    @PositiveOrZero
    private final long teacherId;

    @PositiveOrZero
    private final long groupId;

    @java.beans.ConstructorProperties({"date", "number", "teacherId", "groupId"})
    public AddLessonRequest(String date, int number, long teacherId, long groupId) {
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public String getDate() {
        return date;
    }

    public int getNumber() {
        return number;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public long getGroupId() {
        return groupId;
    }
}
