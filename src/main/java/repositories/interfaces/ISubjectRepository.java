package repositories.interfaces;

import entities.database.Subject;

public interface ISubjectRepository {
    long add(String name);

    void delete(long id);

    void edit(long id, String newName);

    Subject getById(long id);

    Subject[] getAll();

}
