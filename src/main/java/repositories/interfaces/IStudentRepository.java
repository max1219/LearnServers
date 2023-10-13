package repositories.interfaces;

import entities.database.Student;

public interface IStudentRepository {
    long add(String lastName, String firstName, String middleName, long groupId, String status);

    void delete(long id);

    void edit(long id, String lastName, String firstName, String middleName, long groupId, String status);

    Student getById(long id);

    Student[] getAll();
}
