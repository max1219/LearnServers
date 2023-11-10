package repositories.interfaces;

import entities.database.StudentGroup;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface IStudentGroupRepository {
    long add(StudentGroup group) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(StudentGroup group) throws NotFoundException, NotEnoughMemoryException;

    StudentGroup getById(long id) throws NotFoundException;

    StudentGroup[] getAll();
}
