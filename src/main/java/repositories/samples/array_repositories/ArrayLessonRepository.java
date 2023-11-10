package repositories.samples.array_repositories;

import entities.database.Lesson;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;
import repositories.interfaces.ILessonRepository;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class ArrayLessonRepository implements ILessonRepository {
    private final Database database;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArrayLessonRepository(Database database) {
        this.database = database;
        lastId = 0;
        freeId = new LinkedList<>();
    }

    @Override
    public long add(Lesson lesson) throws NotEnoughMemoryException {
        int id;
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.lessons.length) {
                throw new NotEnoughMemoryException();
            }
        }
        lesson = new Lesson((long) id, lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId());
        database.lessons[id] = lesson;
        return id;
    }

    @Override
    public void edit(Lesson lesson) throws NotFoundException, NotEnoughMemoryException {
        if (database.lessons[(int) (long) lesson.getId()] == null) {
            throw new NotFoundException();
        }
        database.lessons[(int) (long) lesson.getId()] = lesson;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (database.lessons[(int) id] == null) {
            throw new NotFoundException();
        }
        database.lessons[(int) id] = null;
    }

    @Override
    public void deleteByTeacherId(long id) {
        for (int i = 0; i < lastId; i++) {
            if (database.lessons[i] == null) continue;
            if (database.lessons[i].getTeacherId() != id) continue;
            database.lessons[i] = null;
        }
    }

    @Override
    public void deleteByGroupId(long id) {
        for (int i = 0; i < lastId; i++) {
            if (database.lessons[i] == null) continue;
            if (database.lessons[i].getGroupId() != id) continue;
            database.lessons[i] = null;
        }
    }

    @Override
    public Lesson getById(long id) throws NotFoundException {
        if (database.lessons[(int) id] == null) {
            throw new NotFoundException();
        }
        return database.lessons[(int) id];
    }

    @Override
    public Lesson[] getByTeacherId(String startDate, String endDate, long id) {
        return Arrays.stream(database.lessons).filter(lesson -> lesson.getTeacherId() == id && lesson.getDate().compareTo(startDate) >= 0 && lesson.getDate().compareTo(endDate) <= 0).toArray(Lesson[]::new);
    }

    @Override
    public Lesson[] getByGroupId(String startDate, String endDate, long id) {
        return Arrays.stream(database.lessons).filter(Objects::nonNull).filter(lesson -> lesson.getGroupId() == id && lesson.getDate().compareTo(startDate) >= 0 && lesson.getDate().compareTo(endDate) <= 0).toArray(Lesson[]::new);
    }
}
