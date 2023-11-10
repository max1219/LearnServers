package repositories.interfaces;

import entities.database.Student;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface IStudentRepository {
    long add(Student student) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void edit(Student student) throws NotFoundException, NotEnoughMemoryException;

    Student getById(long id) throws NotFoundException;

    Student[] getAll();
}
