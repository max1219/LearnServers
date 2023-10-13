package repositories.interfaces;

import entities.database.Teacher;

public interface ITeacherRepository {
    long add(String lastName, String firstName, String middleName);

    void delete(long id);

    void edit(long id, String lastName, String firstName, String middleName);

    Teacher getById(long id);

    Teacher[] getAll();

}
