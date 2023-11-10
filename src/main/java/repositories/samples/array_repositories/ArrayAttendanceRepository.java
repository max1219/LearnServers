package repositories.samples.array_repositories;

import entities.database.Attendance;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;
import repositories.interfaces.IAttendanceRepository;

import java.util.Deque;
import java.util.LinkedList;

public class ArrayAttendanceRepository implements IAttendanceRepository {
    private final Database database;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArrayAttendanceRepository(Database database) {
        this.database = database;
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
        attendance = new Attendance((long) id, attendance.getLessonId(), attendance.getVisitedId());
        database.attendances[id] = attendance;
        return id;
    }

    @Override
    public void edit(Attendance attendance) throws NotEnoughMemoryException, NotFoundException {
        if (database.attendances[(int) (long) attendance.getId()] == null) {
            throw new NotFoundException();
        }
        database.attendances[(int) (long) attendance.getId()] = attendance;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (database.attendances[(int) id] == null) {
            throw new NotFoundException();
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
