package org.ogr.gor.www.old.updated.services.samples;

import org.ogr.gor.www.old.entities.database.StudentGroup;
import org.ogr.gor.www.old.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.DeleteStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.old.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.entities.responses.student_groups.AddStudentGroupResponse;
import org.ogr.gor.www.old.entities.responses.student_groups.GetStudentGroupResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.repositories.interfaces.IStudentGroupRepository;
import org.ogr.gor.www.old.updated.services.interfaces.IStudentGroupService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SampleStudentGroupService implements IStudentGroupService {
    private final IStudentGroupRepository repository;

    public SampleStudentGroupService(IStudentGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetStudentGroupResponse> getStudentGroups() {
        return Arrays.stream(repository.getAll())
                .map(group -> new GetStudentGroupResponse(group.getName(), group.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public GetStudentGroupResponse getStudentGroupById(GetStudentGroupRequest request) throws NotFoundException {
        try {
            StudentGroup studentGroup = repository.getById(request.getId());
            return new GetStudentGroupResponse(studentGroup.getName(), studentGroup.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotEnoughMemoryException {
        try{
            long id = repository.add(new StudentGroup(null, request.getName()));
            return new AddStudentGroupResponse(id);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudentGroup(EditStudentGroupRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(new StudentGroup(request.getId(), request.getNewName()));
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

