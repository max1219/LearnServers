package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.entities.database.Subject;

public interface ISubjectRepository {
    long add(Subject subject) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Subject subject) throws NotFoundException, NotEnoughMemoryException;

    Subject getById(long id) throws NotFoundException;

    Subject[] getAll();

}
