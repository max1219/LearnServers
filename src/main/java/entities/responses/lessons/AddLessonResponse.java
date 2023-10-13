package entities.responses.lessons;

public class AddLessonResponse {
    private final long id;

    public AddLessonResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
