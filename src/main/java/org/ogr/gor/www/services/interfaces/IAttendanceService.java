package org.ogr.gor.www.services.interfaces;

import org.ogr.gor.www.entities.database.Attendance;
import org.ogr.gor.www.entities.requests.lessons.*;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;

public interface IAttendanceService {
    Attendance getAttendance(GetAttendanceRequest request);

    void addAttendance(SetAttendanceRequest request) throws NotEnoughMemoryException;

    void deleteAttendance(DeleteAttendanceRequest request) throws NotFoundException;
}
