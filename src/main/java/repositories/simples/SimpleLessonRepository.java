package repositories.simples;

import entities.database.Lesson;
import repositories.interfaces.ILessonRepository;

public class SimpleLessonRepository implements ILessonRepository {
    @Override
    public long add(Lesson lesson) {
        System.out.print("Add lesson");
        return 0;
    }

    @Override
    public void edit(Lesson lesson) {
        System.out.print("Edit lesson");
    }

    @Override
    public void delete(long id) {
        System.out.print("Delete lesson");
    }

    @Override
    public void deleteByTeacherId(long id) {
        System.out.print("Delete by teacher id lesson");
    }

    @Override
    public void deleteByGroupId(long id) {
        System.out.print("Delete by group id lesson");
    }

    @Override
    public Lesson getById(long id) {
        return new Lesson(0L, "1", 1, 0L, 0L);
    }

    @Override
    public Lesson[] getByTeacherId(String startDate, String endDate, long id) {
        return new Lesson[]{
                new Lesson(0L, "1", 1, 0L, 0L),
                new Lesson(2L, "2", 2, 2L, 2L)
        };
    }

    @Override
    public Lesson[] getByGroupId(String startDate, String endDate, long id) {
        return new Lesson[]{
                new Lesson(0L, "1", 1, 0L, 0L),
                new Lesson(2L, "2", 2, 2L, 2L)
        };
    }
}
