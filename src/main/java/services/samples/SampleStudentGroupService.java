package services.samples;

import entities.database.StudentGroup;
import entities.requests.student_groups.AddStudentGroupRequest;
import entities.requests.student_groups.DeleteStudentGroupRequest;
import entities.requests.student_groups.EditStudentGroupRequest;
import entities.requests.student_groups.GetStudentGroupRequest;
import entities.responses.student_groups.AddStudentGroupResponse;
import entities.responses.student_groups.GetStudentGroupResponse;
import exceptions.service_exceptions.NotEnoughMemoryException;
import exceptions.service_exceptions.NotFoundException;
import repositories.interfaces.IStudentGroupRepository;
import services.interfaces.IStudentGroupService;

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
        } catch (exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotEnoughMemoryException {
        try{
            long id = repository.add(new StudentGroup(null, request.getName()));
            return new AddStudentGroupResponse(id);
        } catch (exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudentGroup(EditStudentGroupRequest request) throws NotFoundException, NotEnoughMemoryException {
        try {
            repository.edit(new StudentGroup(request.getId(), request.getNewName()));
        } catch (exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteStudentGroup(DeleteStudentGroupRequest request) throws NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}

