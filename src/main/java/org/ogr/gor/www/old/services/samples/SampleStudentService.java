package org.ogr.gor.www.old.services.samples;

import org.ogr.gor.www.old.entities.database.Student;
import org.ogr.gor.www.old.entities.requests.students.*;
import org.ogr.gor.www.old.entities.responses.students.AddStudentResponse;
import org.ogr.gor.www.old.entities.responses.students.GetStudentResponse;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.service_exceptions.NotFoundException;
import org.ogr.gor.www.old.repositories.interfaces.IStudentRepository;
import org.ogr.gor.www.old.services.interfaces.IStudentService;

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
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws NotEnoughMemoryException {
        try{
            long id = repository.add(new Student(null, request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getGroupId(), request.getStatus()));
            return new AddStudentResponse(id);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        }
    }

    @Override
    public void editStudent(EditStudentRequest request) throws NotFoundException, NotEnoughMemoryException {
        try{
            repository.edit(new Student(request.getId(), request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getGroupId(), request.getStatus()));
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException e) {
            throw new NotEnoughMemoryException(e);
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) throws NotFoundException {
        try{
            repository.delete(request.getId());
        } catch (org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException e) {
            throw new NotFoundException(e);
        }
    }
}
