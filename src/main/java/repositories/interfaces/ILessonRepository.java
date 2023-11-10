package repositories.interfaces;

import entities.database.Lesson;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface ILessonRepository {

    long add(Lesson lesson) throws NotEnoughMemoryException;

    void edit(Lesson lesson) throws NotFoundException, NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    void deleteByTeacherId(long id);

    void deleteByGroupId(long id);

    Lesson getById(long id) throws NotFoundException;

    Lesson[] getByTeacherId(String startDate, String endDate, long id);

    Lesson[] getByGroupId(String startDate, String endDate, long id);

}
