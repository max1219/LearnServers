package entities.requests.subjects;

public class EditSubjectRequest {
    private final long id;
    private final String name;

    public EditSubjectRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EditSubjectRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
