package repositories.interfaces;

import entities.database.StudentGroup;

public interface IStudentGroupRepository {
    long add(String name);

    void delete(long id);

    void edit(long id, String newName);

    StudentGroup getById(long id);

    StudentGroup[] getAll();
}
