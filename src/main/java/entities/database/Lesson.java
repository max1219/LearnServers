package entities.database;

import java.util.Objects;

public class Lesson {
    private final Long id;
    private final String date;
    private final int number;
    private final long teacherId;
    private final long groupId;

    public Lesson(Long id, String date, int number, long teacherId, long groupId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public Long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return number == lesson.number && teacherId == lesson.teacherId && groupId == lesson.groupId && Objects.equals(id, lesson.id) && Objects.equals(date, lesson.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, number, teacherId, groupId);
    }
}
