package repositories.samples.array_repositories;

import entities.database.StudentGroup;
import exceptions.repository_exceptions.NotEnoughMemoryException;
import exceptions.repository_exceptions.NotFoundException;
import repositories.interfaces.IStudentGroupRepository;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class ArrayStudentGroupRepository implements IStudentGroupRepository {
    private final Database database;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArrayStudentGroupRepository(Database database) {
        this.database = database;
        lastId = 0;
        freeId = new LinkedList<>();
    }

    @Override
    public long add(StudentGroup group) throws NotEnoughMemoryException {
        int id;
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.studentGroups.length) {
                throw new NotEnoughMemoryException();
            }
        }
        group = new StudentGroup((long) id, group.getName());
        database.studentGroups[id] = group;
        return id;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (database.studentGroups[(int) id] == null) {
            throw new NotFoundException();
        }
        database.studentGroups[(int) id] = null;
    }

    @Override
    public void edit(StudentGroup group) throws NotFoundException, NotEnoughMemoryException {
        if (database.studentGroups[(int) (long) group.getId()] == null) {
            throw new NotFoundException();
        }
        database.studentGroups[(int) (long) group.getId()] = group;
    }

    @Override
    public StudentGroup getById(long id) throws NotFoundException {
        if (database.studentGroups[(int) id] == null) {
            throw new NotFoundException();
        }
        return database.studentGroups[(int) id];
    }

    @Override
    public StudentGroup[] getAll() {
        return Arrays.stream(database.studentGroups).filter(Objects::nonNull).toArray(StudentGroup[]::new);
    }
}
