package org.ogr.gor.www.entities.requests.lessons;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class EditLessonRequest {
    @PositiveOrZero
    private final long id;

    @NotNull
    @Pattern(regexp = "^\\d\\d[._\\- ]\\d\\d[._\\- ]\\d\\d\\d\\d$")
    private final String date;

    @Positive
    private final int number;

    @PositiveOrZero
    private final long teacherId;

    @PositiveOrZero
    private final long groupId;

    @java.beans.ConstructorProperties({"id", "date", "number", "teacherId", "groupId"})
    public EditLessonRequest(long id, String date, int number, long teacherId, long groupId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public long getId() {
        return id;
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
