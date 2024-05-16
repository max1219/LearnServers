package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Lesson;
import org.ogr.gor.www.entities.requests.lessons.*;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.ILessonRepository;
import org.ogr.gor.www.services.interfaces.ILessonService;
import org.springframework.stereotype.Component;

@Component
public class SampleLessonService implements ILessonService {
    private final ILessonRepository repository;

    public SampleLessonService(ILessonRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lesson[] getLessonsByGroup(GetLessonsByGroupRequest request) {
        return repository.getByGroupId(request.getStartDate(), request.getEndDate(), request.getGroupId());
    }

    @Override
    public Lesson[] getLessonsByTeacher(GetLessonsByTeacherRequest request) {
        return repository.getByGroupId(request.getStartDate(), request.getEndDate(), request.getTeacherId());
    }

    @Override
    public Lesson getLessonById(GetLessonByIdRequest request) throws NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public long addLesson(AddLessonRequest request) throws NotEnoughMemoryException {
        try {
            return repository.add(new Lesson(null, request.getDate(), request.getNumber(),
                    request.getTeacherId(), request.getGroupId()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editLesson(EditLessonRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(new Lesson(request.getId(), request.getDate(), request.getNumber(),
                    request.getTeacherId(), request.getGroupId()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteLesson(DeleteLessonRequest request) throws NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
