package org.ogr.gor.www.old.repositories.samples.array_repositories;

import org.ogr.gor.www.old.updated.entities.database.Teacher;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotEnoughMemoryException;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.old.repositories.interfaces.ITeacherRepository;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class ArrayTeacherRepository implements ITeacherRepository {
    private final Database database;
    private Integer lastId;
    private final Deque<Integer> freeId;

    public ArrayTeacherRepository(Database database) {
        this.database = database;
        lastId = 0;
        freeId = new LinkedList<>();
    }

    @Override
    public long add(Teacher teacher) throws NotEnoughMemoryException {
        int id;
        if (freeId.peekFirst() != null) {
            id = freeId.pop();
        } else {
            id = lastId++;
            if (id == database.teachers.length) {
                throw new NotEnoughMemoryException();
            }
        }
        teacher = new Teacher((long) id, teacher.getLastName(), teacher.getFirstName(), teacher.getMiddleName());
        database.teachers[id] = teacher;
        return id;
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (database.teachers[(int) id] == null) {
            throw new NotFoundException();
        }
        database.teachers[(int) id] = null;
    }

    @Override
    public void edit(Teacher teacher) throws NotFoundException, NotEnoughMemoryException {
        if (database.teachers[(int) (long) teacher.getId()] == null) {
            throw new NotFoundException();
        }
        database.teachers[(int) (long) teacher.getId()] = teacher;
    }

    @Override
    public Teacher getById(long id) throws NotFoundException {
        if (database.teachers[(int) id] == null) {
            throw new NotFoundException();
        }
        return database.teachers[(int) id];
    }

    @Override
    public Teacher[] getAll() {
        return Arrays.stream(database.teachers).filter(Objects::nonNull).toArray(Teacher[]::new);
    }
}
