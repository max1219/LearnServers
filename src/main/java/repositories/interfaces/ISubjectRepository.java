package repositories.interfaces;

import entities.database.Subject;

public interface ISubjectRepository {
    long add(Subject subject);

    void delete(long id);

    void edit(Subject subject);

    Subject getById(long id);

    Subject[] getAll();

}
