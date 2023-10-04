package entities.requests.lessons;

public class DeleteLessonId {
    private final long id;

    public DeleteLessonId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DeleteLessonId(" + id + ")";
    }
}
