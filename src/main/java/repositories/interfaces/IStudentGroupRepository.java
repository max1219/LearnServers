package repositories.interfaces;

import entities.database.StudentGroup;

public interface IStudentGroupRepository {
    long add(StudentGroup group);

    void delete(long id);

    void edit(StudentGroup group);

    StudentGroup getById(long id);

    StudentGroup[] getAll();
}
