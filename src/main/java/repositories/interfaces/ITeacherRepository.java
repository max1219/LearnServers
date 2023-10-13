package repositories.interfaces;

import entities.database.Teacher;

public interface ITeacherRepository {
    long add(Teacher teacher);

    void delete(long id);

    void edit(Teacher teacher);

    Teacher getById(long id);

    Teacher[] getAll();

}
