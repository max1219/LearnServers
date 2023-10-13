package entities.database;

public class StudentGroup{
    private final Long id;
    private final String name;

    public StudentGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GetStudentGroupsResponse.StudentGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}