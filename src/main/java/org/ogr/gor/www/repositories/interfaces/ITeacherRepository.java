package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.entities.database.Teacher;

public interface ITeacherRepository {
    long add(Teacher teacher) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Teacher teacher) throws NotFoundException, NotEnoughMemoryException;

    Teacher getById(long id) throws NotFoundException;

    Teacher[] getAll();

}
