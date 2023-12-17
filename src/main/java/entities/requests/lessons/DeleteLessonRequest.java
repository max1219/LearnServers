package entities.requests.lessons;

public class DeleteLessonRequest {
    private final long id;

    @java.beans.ConstructorProperties({"id"})
    public DeleteLessonRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
