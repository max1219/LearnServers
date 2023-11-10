package repositories.interfaces;

import entities.database.Teacher;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface ITeacherRepository {
    long add(Teacher teacher) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Teacher teacher) throws NotFoundException, NotEnoughMemoryException;

    Teacher getById(long id) throws NotFoundException;

    Teacher[] getAll();

}
