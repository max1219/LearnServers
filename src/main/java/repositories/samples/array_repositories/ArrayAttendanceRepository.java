package repositories.samples.array_repositories;

import entities.database.Attendance;
import entities.database.Lesson;
import exceptions.repository_exceptions.ImATeapotException;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;
import repositories.interfaces.IAttendanceRepository;
import repositories.interfaces.ILessonRepository;

import java.util.Deque;
import java.util.LinkedList;

public class ArrayAttendanceRepository implements IAttendanceRepository {
    private final Database database;
    private final ILessonRepository lessonRepository;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArrayAttendanceRepository(Database database, ILessonRepository lessonRepository) {
        this.database = database;
        this.lessonRepository = lessonRepository;
        lastId = 0;
        freeId = new LinkedList<>();
    }

    @Override
    public long add(Attendance attendance) throws NotEnoughMemoryException, NotFoundException {
        int id;
        Lesson lesson;
        try {
            lesson = lessonRepository.getById(attendance.getLessonId());
        } catch (NotFoundException e) {
            throw new NotFoundException("Не нашли занятие, к которому прикрепляем посещаемость", e);
        }
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.attendances.length) {
                throw new NotEnoughMemoryException();
            }
        }
        lesson = new Lesson(lesson.getId(), (long) id, lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId());
        attendance = new Attendance((long) id, attendance.getLessonId(), attendance.getVisitedId());
        database.attendances[id] = attendance;
        try {
            lessonRepository.edit(lesson);
        } catch (NotEnoughMemoryException e) {
            database.attendances[id] = null;
            throw new NotEnoughMemoryException("Не хватает памяти, чтобы добавить id посещаемости в бд занятий");
        }
        return id;
    }

    @Override
    public void edit(Attendance attendance) throws NotEnoughMemoryException, NotFoundException, ImATeapotException {
        // Да, теперь я понял, что плохо спроектировал сущности. Просто надеемся, что в edit не меняется lessonId
        Attendance attendance1 = database.attendances[(int) (long) attendance.getId()];
        if (attendance1 == null) {
            throw new NotFoundException();
        }
        if (attendance1.getLessonId() != attendance.getLessonId()) {
            throw new ImATeapotException("Невозможно заменить lessonId в attendance");
        }
        database.attendances[(int) (long) attendance.getId()] = attendance;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        Attendance attendance = database.attendances[(int) id];
        if (attendance == null) {
            throw new NotFoundException();
        }
        Lesson lesson;
        try {
            lesson = lessonRepository.getById(attendance.getLessonId());
            lessonRepository.edit(new Lesson(lesson.getId(), null, lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId()));
        } catch (NotFoundException | NotEnoughMemoryException ignored) {
        }
        database.attendances[(int) id] = null;
    }

    @Override
    public Attendance getById(long id) throws NotFoundException {
        if (database.attendances[(int) id] == null) {
            throw new NotFoundException();
        }
        return database.attendances[(int) id];
    }
}
