package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.database.Subject;
import org.ogr.gor.www.entities.requests.subjects.AddSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.DeleteSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.EditSubjectRequest;
import org.ogr.gor.www.entities.requests.subjects.GetSubjectByIdRequest;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
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
    public Subject getSubjectById(GetSubjectByIdRequest request) throws NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public long addSubject(AddSubjectRequest request) throws NotEnoughMemoryException {
        try {
            return repository.add(new Subject(null, request.getName()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editSubject(EditSubjectRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(new Subject(request.getId(), request.getName()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteSubject(DeleteSubjectRequest request) throws NotFoundException {
        try {
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}

