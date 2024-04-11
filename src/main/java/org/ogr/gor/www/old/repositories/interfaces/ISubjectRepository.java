package org.ogr.gor.www.old.repositories.interfaces;

import org.ogr.gor.www.old.entities.database.Subject;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;

public interface ISubjectRepository {
    long add(Subject subject) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Subject subject) throws NotFoundException, NotEnoughMemoryException;

    Subject getById(long id) throws NotFoundException;

    Subject[] getAll();

}
