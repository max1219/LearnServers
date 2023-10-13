package repositories.interfaces;

import entities.database.Student;

public interface IStudentRepository {
    long add(Student student);

    void delete(long id);

    void edit(Student student);

    Student getById(long id);

    Student[] getAll();
}
