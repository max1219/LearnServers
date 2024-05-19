package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.requests.students.*;
import org.ogr.gor.www.entities.database.Student;
import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.IStudentRepository;
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
    public Student getStudentById(GetStudentByIdRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public long addStudent(AddStudentRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            return repository.add(
                    new Student(null,
                            request.getLastName(),
                            request.getFirstName(),
                            request.getMiddleName(),
                            request.getGroupId(),
                            request.getStatus()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudent(EditStudentRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException, org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            repository.edit(
                    new Student(request.getId(),
                            request.getLastName(),
                            request.getFirstName(),
                            request.getMiddleName(),
                            request.getGroupId(),
                            request.getStatus()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }
}
