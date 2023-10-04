package entities.requests.subjects;

public class AddSubjectRequest {
    private final String name;

    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AddSubjectRequest(" + name + ")";
    }
}
