package entities.responses.subjects;

public class GetSubjectResponse {
    private final long id;
    private final String name;

    public GetSubjectResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
