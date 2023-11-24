package services.samples;

import entities.database.Student;
import entities.requests.students.*;
import entities.responses.students.AddStudentResponse;
import entities.responses.students.GetStudentResponse;
import exceptions.service_exceptions.NotEnoughMemoryException;
import exceptions.service_exceptions.NotFoundException;
import repositories.interfaces.IStudentRepository;
import services.interfaces.IStudentService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SampleStudentService implements IStudentService {
    private final IStudentRepository repository;

    public SampleStudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetStudentResponse> getStudentsByGroup(GetStudentsByGroupRequest request) {
        return Arrays.stream(repository.getByGroup(request.getId()))
                .map(student -> new GetStudentResponse(student.getId(), student.getLastName(), student.getFirstName(),
                        student.getMiddleName(), student.getGroupId(), student.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public GetStudentResponse getStudentById(GetStudentByIdRequest request) throws NotFoundException {
        try {
            Student student = repository.getById(request.getId());
            return new GetStudentResponse(student.getId(), student.getLastName(), student.getFirstName(),
                    student.getMiddleName(), student.getGroupId(), student.getStatus());
        } catch (exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws NotEnoughMemoryException {
        try{
            long id = repository.add(new Student(null, request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getGroupId(), request.getStatus()));
            return new AddStudentResponse(id);
        } catch (exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudent(EditStudentRequest request) throws NotFoundException, NotEnoughMemoryException {
        try{
            repository.edit(new Student(request.getId(), request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getGroupId(), request.getStatus()));
        } catch (exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) throws NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
