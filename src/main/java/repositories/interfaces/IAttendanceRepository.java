package repositories.interfaces;

import entities.database.Attendance;

public interface IAttendanceRepository {
    long add(Attendance attendance);

    void edit(Attendance attendance);

    void delete(long id);

    Attendance getById(long id);

}
