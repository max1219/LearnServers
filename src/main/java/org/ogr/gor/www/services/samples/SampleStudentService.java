package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.requests.students.*;
import org.ogr.gor.www.old.entities.database.Student;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.repositories.interfaces.IStudentRepository;
import org.ogr.gor.www.services.interfaces.IStudentService;
import org.springframework.stereotype.Component;

@Component
public class SampleStudentService implements IStudentService {
    private final IStudentRepository repository;

    public SampleStudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student[] getStudentsByGroup(GetStudentsByGroupRequest request) {
        return repository.getByGroup(request.getId());
    }

    @Override
    public Student getStudentById(GetStudentByIdRequest request) throws NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public long addStudent(AddStudentRequest request) throws NotEnoughMemoryException {
        try {
            return repository.add(
                    new Student(null,
                            request.getLastName(),
                            request.getFirstName(),
                            request.getMiddleName(),
                            request.getGroupId(),
                            request.getStatus()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudent(EditStudentRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(
                    new Student(request.getId(),
                            request.getLastName(),
                            request.getFirstName(),
                            request.getMiddleName(),
                            request.getGroupId(),
                            request.getStatus()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) throws NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
