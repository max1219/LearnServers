package repositories.samples.array_repositories;

import entities.database.Student;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;
import repositories.interfaces.IStudentRepository;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class ArrayStudentRepository implements IStudentRepository {
    private final Database database;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArrayStudentRepository(Database database) {
        this.database = database;
        lastId = 0;
        freeId = new LinkedList<>();
    }

    @Override
    public long add(Student student) throws NotEnoughMemoryException {
        int id;
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.students.length) {
                throw new NotEnoughMemoryException();
            }
        }
        student = new Student((long) id, student.getLastName(), student.getFirstName(), student.getMiddleName(), student.getGroupId(), student.getStatus());
        database.students[id] = student;
        return id;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (database.students[(int) id] == null) {
            throw new NotFoundException();
        }
        database.students[(int) id] = null;
    }

    @Override
    public void edit(Student student) throws NotFoundException, NotEnoughMemoryException {
        if (database.students[(int) (long) student.getId()] == null) {
            throw new NotFoundException();
        }
        database.students[(int) (long) student.getId()] = student;
    }

    @Override
    public Student getById(long id) throws NotFoundException {
        if (database.students[(int) id] == null) {
            throw new NotFoundException();
        }
        return database.students[(int) id];
    }

    @Override
    public Student[] getByGroup(long groupId) {
        return Arrays.stream(database.students).filter(Objects::nonNull).filter(student -> student.getGroupId() == groupId).toArray(Student[]::new);
    }

    @Override
    public Student[] getAll() {
        return Arrays.stream(database.students).filter(Objects::nonNull).toArray(Student[]::new);
    }
}
