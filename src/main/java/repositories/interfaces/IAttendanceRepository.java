package repositories.interfaces;

import entities.database.Attendance;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface IAttendanceRepository {
    long add(Attendance attendance) throws NotEnoughMemoryException;

    void delete(long id);

    Attendance getById(long id);

}
