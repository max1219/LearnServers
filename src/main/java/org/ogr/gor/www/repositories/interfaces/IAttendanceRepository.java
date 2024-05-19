package org.ogr.gor.www.repositories.interfaces;

import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.entities.database.Attendance;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;

public interface IAttendanceRepository {
    void add(Attendance attendance) throws NotEnoughMemoryException;

    void delete(long id) throws NotFoundException;

    Attendance getById(long id);

}
