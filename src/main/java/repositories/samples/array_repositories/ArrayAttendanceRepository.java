package repositories.samples.array_repositories;

import entities.database.Attendance;
import exceptions.repository_exceptions.NotEnoughMemoryException;
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
    public long add(Attendance attendance) throws NotEnoughMemoryException {
        int id;
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.attendances.length) {
                throw new NotEnoughMemoryException();
            }
        }
        attendance = new Attendance((long) id, attendance.getVisitedId());
        database.attendances[id] = attendance;
        return id;
    }

    @Override
    public void delete(long id) {
        database.attendances[(int) id] = null;
    }

    @Override
    public Attendance getById(long id) {
        return database.attendances[(int) id];
    }
}