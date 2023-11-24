package entities.responses.lessons;

public class GetLessonResponse {
    private final long id;
    private final String date;
    private final int number;
    private final long teacherId;
    private final long groupId;
    private final Long attendanceId;

    public GetLessonResponse(long id, String date, int number, long teacherId, long groupId, Long attendanceId) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.teacherId = teacherId;
        this.groupId = groupId;
        this.attendanceId = attendanceId;
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

    public Long getAttendanceId() {
        return attendanceId;
    }
}
