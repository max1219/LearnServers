package entities.requests.lessons;

public class GetLessonByIdRequest {
    private final long id;

    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GetLessonByIdRequest(" + id + ")";
    }
}
