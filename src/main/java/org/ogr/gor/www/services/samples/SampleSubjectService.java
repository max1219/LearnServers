package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Subject;
import org.ogr.gor.www.entities.requests.subjects.AddSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.DeleteSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.EditSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.GetSubjectByIdRequest;
import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.ISubjectRepository;
import org.ogr.gor.www.services.interfaces.ISubjectService;
import org.springframework.stereotype.Component;


@Component
public class SampleSubjectService implements ISubjectService {
    private final ISubjectRepository repository;


    public SampleSubjectService(ISubjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subject[] getSubjects() {
        return repository.getAll();
    }

    @Override
    public Subject getSubjectById(GetSubjectByIdRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public long addSubject(AddSubjectRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            return repository.add(new Subject(null, request.getName()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editSubject(EditSubjectRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException, org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            repository.edit(new Subject(request.getId(), request.getName()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public void deleteSubject(DeleteSubjectRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }
}

