package repositories.interfaces;

import entities.database.Subject;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface ISubjectRepository {
    long add(Subject subject) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Subject subject) throws NotFoundException, NotEnoughMemoryException;

    Subject getById(long id) throws NotFoundException;

    Subject[] getAll();

}
