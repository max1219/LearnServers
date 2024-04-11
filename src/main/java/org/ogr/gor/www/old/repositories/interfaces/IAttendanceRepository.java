package org.ogr.gor.www.old.repositories.interfaces;

import org.ogr.gor.www.old.entities.database.Attendance;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;

public interface IAttendanceRepository {
    long add(Attendance attendance) throws NotEnoughMemoryException;

    void delete(long id);

    Attendance getById(long id);

}
