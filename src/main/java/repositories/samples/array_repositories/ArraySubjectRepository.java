package repositories.samples.array_repositories;

import entities.database.Subject;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;
import repositories.interfaces.ISubjectRepository;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class ArraySubjectRepository implements ISubjectRepository {
    private final Database database;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArraySubjectRepository(Database database) {
        this.database = database;
        lastId = 0;
        freeId = new LinkedList<>();
    }

    @Override
    public long add(Subject subject) throws NotEnoughMemoryException {
        int id;
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.subjects.length) {
                throw new NotEnoughMemoryException();
            }
        }
        subject = new Subject((long) id, subject.getName());
        database.subjects[id] = subject;
        return id;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (database.subjects[(int) id] == null) {
            throw new NotFoundException();
        }
        database.subjects[(int) id] = null;
    }

    @Override
    public void edit(Subject subject) throws NotFoundException, NotEnoughMemoryException {
        if (database.subjects[(int) (long) subject.getId()] == null) {
            throw new NotFoundException();
        }
        database.subjects[(int) (long) subject.getId()] = subject;
    }

    @Override
    public Subject getById(long id) throws NotFoundException {
        if (database.subjects[(int) id] == null) {
            throw new NotFoundException();
        }
        return database.subjects[(int) id];
    }

    @Override
    public Subject[] getAll() {
        return Arrays.stream(database.subjects).filter(Objects::nonNull).toArray(Subject[]::new);
    }
}
