package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.entities.database.StudentGroup;

public interface IStudentGroupRepository {
    long add(StudentGroup group) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(StudentGroup group) throws NotFoundException, NotEnoughMemoryException;

    StudentGroup getById(long id) throws NotFoundException;

    StudentGroup[] getAll();
}
