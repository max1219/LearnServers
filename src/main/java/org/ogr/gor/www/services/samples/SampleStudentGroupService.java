package org.ogr.gor.www.services.samples;

import org.ogr.gor.www.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.services.interfaces.IStudentGroupService;
import org.ogr.gor.www.entities.database.StudentGroup;
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
    public StudentGroup getStudentGroupById(GetStudentGroupRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try {
            return repository.getById(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }

    @Override
    public long addStudentGroup(AddStudentGroupRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try{
            return repository.add(new StudentGroup(null, request.getName()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudentGroup(EditStudentGroupRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException, org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException {
        try {
            repository.edit(new StudentGroup(request.getId(), request.getName()));
        } catch (NotEnoughMemoryException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotEnoughMemoryException(e);
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }

    }

    @Override
    public void deleteStudentGroup(DeleteStudentGroupRequest request) throws org.ogr.gor.www.exceptions.service_exceptions.NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (NotFoundException e) {
            throw new org.ogr.gor.www.exceptions.service_exceptions.NotFoundException(e);
        }
    }
}

