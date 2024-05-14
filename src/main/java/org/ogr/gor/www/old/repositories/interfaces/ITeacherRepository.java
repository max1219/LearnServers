package org.ogr.gor.www.old.repositories.interfaces;

import org.ogr.gor.www.old.updated.entities.database.Teacher;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;

public interface ITeacherRepository {
    long add(Teacher teacher) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Teacher teacher) throws NotFoundException, NotEnoughMemoryException;

    Teacher getById(long id) throws NotFoundException;

    Teacher[] getAll();

}
