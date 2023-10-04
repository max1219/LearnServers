package entities.requests.lessons;

public class GetLessonsByTeacherRequest {
    private final String startDate;
    private final String endDate;
    private final long teacherId;

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

    @Override
    public String toString() {
        return "GetLessonsByTeacherRequest{" +
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}
