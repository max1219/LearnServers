package repositories.simples;

import entities.database.Student;
import repositories.interfaces.IStudentRepository;

public class SimpleStudentRepository implements IStudentRepository {
    @Override
    public long add(Student student) {
        System.out.print("Add student");
        return 0;
    }

    @Override
    public void delete(long id) {
        System.out.print("Delete student");
    }

    @Override
    public void edit(Student student) {
        System.out.print("Edit student");
    }

    @Override
    public Student getById(long id) {
        return new Student(id, "A", "B", "C", 0L, "D");
    }

    @Override
    public Student[] getAll() {
        return new Student[]{
                new Student(0L, "A", "B", "C", 0L, "D"),
                new Student(1L, "A1", "B1", "C1", 0L, "D1")
        };
    }
}
