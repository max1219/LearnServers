package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Attendance;
import org.ogr.gor.www.entities.requests.lessons.DeleteAttendanceRequest;
import org.ogr.gor.www.entities.requests.lessons.GetAttendanceRequest;
import org.ogr.gor.www.entities.requests.lessons.SetAttendanceRequest;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.IAttendanceRepository;
import org.ogr.gor.www.services.interfaces.IAttendanceService;
import org.springframework.stereotype.Component;


@Component
public class SampleAttendanceService implements IAttendanceService {
    private final IAttendanceRepository repository;


    public SampleAttendanceService(IAttendanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Attendance getAttendance(GetAttendanceRequest request) {
        return repository.getById(request.getId());
    }

    @Override
    public void addAttendance(SetAttendanceRequest request) throws NotEnoughMemoryException {
        try {
            repository.add(new Attendance(
                    request.getLessonId(), request.getVisitedId().stream().mapToLong(value -> value).toArray()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void deleteAttendance(DeleteAttendanceRequest request) throws NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}

