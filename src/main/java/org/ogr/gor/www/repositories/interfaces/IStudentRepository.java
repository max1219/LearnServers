package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.entities.database.Student;

public interface IStudentRepository {
    long add(Student student) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Student student) throws NotFoundException, NotEnoughMemoryException;

    Student getById(long id) throws NotFoundException;

    Student[] getByGroup(long groupId);

    Student[] getAll();
}
