package org.ogr.gor.www.old.repositories.interfaces;

import org.ogr.gor.www.old.updated.entities.database.Student;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;

public interface IStudentRepository {
    long add(Student student) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Student student) throws NotFoundException, NotEnoughMemoryException;

    Student getById(long id) throws NotFoundException;

    Student[] getByGroup(long groupId);

    Student[] getAll();
}
