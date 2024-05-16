package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Student;
import org.ogr.gor.www.entities.database.Teacher;
import org.ogr.gor.www.entities.requests.students.*;
import org.ogr.gor.www.entities.requests.teachers.AddTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.DeleteTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.EditTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.GetTeacherByIdRequest;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.ITeacherRepository;
import org.ogr.gor.www.services.interfaces.ITeacherService;
import org.springframework.stereotype.Component;

@Component
public class SampleTeacherService implements ITeacherService {
    private final ITeacherRepository repository;

    public SampleTeacherService(ITeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public Teacher[] getTeachers() {
        return repository.getAll();
    }

    @Override
    public Teacher getTeacherById(GetTeacherByIdRequest request) throws NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public long addTeacher(AddTeacherRequest request) throws NotEnoughMemoryException {
        try {
            return repository.add(new Teacher(
                    null, request.getLastName(), request.getFirstName(), request.getMiddleName()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editTeacher(EditTeacherRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(new Teacher(
                    request.getId(), request.getLastName(), request.getFirstName(), request.getMiddleName()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteTeacher(DeleteTeacherRequest request) throws NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
