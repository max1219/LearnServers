package repositories.interfaces;

import entities.database.Attendance;
import exceptions.repository_exceptions.NotEnoughMemoryException;

public interface IAttendanceRepository {
    long add(Attendance attendance) throws NotEnoughMemoryException;

    void delete(long id);

    Attendance getById(long id);

}
