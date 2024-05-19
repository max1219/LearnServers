package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Lesson;
import org.ogr.gor.www.entities.requests.lessons.*;
import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
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
    public Lesson getLessonById(GetLessonByIdRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public long addLesson(AddLessonRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            return repository.add(new Lesson(null, request.getDate(), request.getNumber(),
                    request.getTeacherId(), request.getGroupId()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editLesson(EditLessonRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException, org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            repository.edit(new Lesson(request.getId(), request.getDate(), request.getNumber(),
                    request.getTeacherId(), request.getGroupId()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public void deleteLesson(DeleteLessonRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }
}
