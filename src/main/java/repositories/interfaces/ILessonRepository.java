package repositories.interfaces;

import entities.database.Lesson;

public interface ILessonRepository {
    long add(String date, int number, long teacherId, long groupId);

    void edit(long id, String date, int number, long teacherId, long groupId);

    void delete(long id);

    void deleteByTeacherId(long id);

    void deleteByGroupId(long id);

    Lesson getById(long id);

    Lesson[] getByTeacherId(String startDate, String endDate, long id);

    Lesson[] getByGroupId(String startDate, String endDate, long id);

}
