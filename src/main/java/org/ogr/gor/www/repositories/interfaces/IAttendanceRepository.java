package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.updated.entities.database.Attendance;

public interface IAttendanceRepository {
    long add(Attendance attendance) throws NotEnoughMemoryException;

    void delete(long id);

    Attendance getById(long id);

}
