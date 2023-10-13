package repositories.interfaces;

import entities.database.Attendance;

public interface IAttendanceRepository {
    long add(String name);

    void edit(long id, String newName);

    void delete(long id);

    Attendance getById(long id);

}
