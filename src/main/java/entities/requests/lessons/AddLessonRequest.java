package entities.requests.lessons;

public class AddLessonRequest {
    private final String date;
    private final int number;
    private final long teacherId;
    private final long groupId;

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
