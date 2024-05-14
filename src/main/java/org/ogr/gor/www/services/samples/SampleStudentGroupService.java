package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.services.interfaces.IStudentGroupService;
import org.ogr.gor.www.entities.database.StudentGroup;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.IStudentGroupRepository;
import org.springframework.stereotype.Component;


@Component
public class SampleStudentGroupService implements IStudentGroupService {
    private final IStudentGroupRepository repository;

    public SampleStudentGroupService(IStudentGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentGroup[] getStudentGroups() {
        return repository.getAll();
    }

    @Override
    public StudentGroup getStudentGroupById(GetStudentGroupRequest request) throws NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public long addStudentGroup(AddStudentGroupRequest request) throws NotEnoughMemoryException {
        try{
            return repository.add(new StudentGroup(null, request.getName()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudentGroup(EditStudentGroupRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(new StudentGroup(request.getId(), request.getName()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }

    }

    @Override
    public void deleteStudentGroup(DeleteStudentGroupRequest request) throws NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}

