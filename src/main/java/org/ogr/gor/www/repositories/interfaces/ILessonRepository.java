package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.entities.database.Lesson;

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
