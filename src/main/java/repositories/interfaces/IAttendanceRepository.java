package repositories.interfaces;

import entities.database.Attendance;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;

public interface IAttendanceRepository {
    long add(Attendance attendance) throws NotEnoughMemoryException, NotFoundException;

    void edit(Attendance attendance) throws NotEnoughMemoryException, NotFoundException;

    void delete(long id) throws NotFoundException;

    Attendance getById(long id) throws NotFoundException;

}
