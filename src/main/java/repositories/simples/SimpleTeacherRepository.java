package repositories.simples;

import entities.database.Teacher;
import repositories.interfaces.ITeacherRepository;

public class SimpleTeacherRepository implements ITeacherRepository {
    @Override
    public long add(Teacher teacher) {
        System.out.print("Add teacher");
        return 0;
    }

    @Override
    public void delete(long id) {
        System.out.print("Delete teacher");
    }

    @Override
    public void edit(Teacher teacher) {
        System.out.print("Edit teacher");
    }

    @Override
    public Teacher getById(long id) {
        return new Teacher(0L, "A", "B", "C");
    }

    @Override
    public Teacher[] getAll() {
        return new Teacher[]{
                new Teacher(0L, "A", "B", "C"),
                new Teacher(1L, "A1", "B1", "C1")
        };
    }
}
