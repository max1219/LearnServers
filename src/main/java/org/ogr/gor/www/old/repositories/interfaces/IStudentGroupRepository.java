package org.ogr.gor.www.old.repositories.interfaces;

import org.ogr.gor.www.old.entities.database.StudentGroup;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;

public interface IStudentGroupRepository {
    long add(StudentGroup group) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(StudentGroup group) throws NotFoundException, NotEnoughMemoryException;

    StudentGroup getById(long id) throws NotFoundException;

    StudentGroup[] getAll();
}
