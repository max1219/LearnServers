package entities.database;

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


}
