package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Teacher;
import org.ogr.gor.www.entities.requests.teachers.AddTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.DeleteTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.EditTeacherRequest;
import org.ogr.gor.www.entities.requests.teachers.GetTeacherByIdRequest;
import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
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
    public Teacher getTeacherById(GetTeacherByIdRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public long addTeacher(AddTeacherRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            return repository.add(new Teacher(
                    null, request.getLastName(), request.getFirstName(), request.getMiddleName()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editTeacher(EditTeacherRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException, org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            repository.edit(new Teacher(
                    request.getId(), request.getLastName(), request.getFirstName(), request.getMiddleName()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public void deleteTeacher(DeleteTeacherRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }
}
