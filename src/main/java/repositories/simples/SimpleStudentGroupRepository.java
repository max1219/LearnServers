package repositories.simples;

import entities.database.StudentGroup;
import repositories.interfaces.IStudentGroupRepository;

public class SimpleStudentGroupRepository implements IStudentGroupRepository {
    @Override
    public long add(StudentGroup group) {
        System.out.print("Add student group");
        return 0;
    }

    @Override
    public void delete(long id) {
        System.out.print("Delete student group");
    }

    @Override
    public void edit(StudentGroup group) {
        System.out.print("Edit student group");
    }

    @Override
    public StudentGroup getById(long id) {
        return new StudentGroup(0L, "N");
    }

    @Override
    public StudentGroup[] getAll() {
        return new StudentGroup[]{
                new StudentGroup(0L, "N0"),
                new StudentGroup(1L, "N1")
        };
    }
}
