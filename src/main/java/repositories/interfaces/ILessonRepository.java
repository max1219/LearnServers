package repositories.interfaces;

import entities.database.Lesson;

public interface ILessonRepository {
    long add(Lesson lesson);

    void edit(Lesson lesson);

    void delete(long id);

    void deleteByTeacherId(long id);

    void deleteByGroupId(long id);

    Lesson getById(long id);

    Lesson[] getByTeacherId(String startDate, String endDate, long id);

    Lesson[] getByGroupId(String startDate, String endDate, long id);

}
