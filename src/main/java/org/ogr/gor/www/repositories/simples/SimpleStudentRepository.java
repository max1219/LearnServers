package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.Student;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.IStudentRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SimpleStudentRepository implements IStudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public SimpleStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(Student student) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(
                "INSERT INTO student (lastname, firstname, middlename, status, group_id) VALUES (?, ?, ?, ?, ?) " +
                        "RETURNING id", Long.class,
                student.getLastName(), student.getFirstName(), student.getMiddleName(),
                student.getStatus(), student.getGroupId()));
    }

    @Override
    public void delete(long id) throws NotFoundException {
        int affected = jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public void edit(Student student) throws NotFoundException {
        int affected = jdbcTemplate.update(
                "UPDATE student SET " +
                        "lastname = ?, firstname = ?, middlename = ?, status = ?, group_id = ? " +
                        "WHERE id = ?",
                student.getLastName(), student.getFirstName(), student.getMiddleName(),
                student.getStatus(), student.getGroupId(), student.getId());
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public Student getById(long id) throws NotFoundException {
        Student result;
        try {
            result = jdbcTemplate.queryForObject(
                    "SELECT id, lastname, firstname, middlename, status, group_id " +
                            "FROM student WHERE id = ?",
                    (resultSet, rowNum) -> new Student(
                            resultSet.getLong("id"),
                            resultSet.getString("lastname"),
                            resultSet.getString("firstname"),
                            resultSet.getString("middlename"),
                            resultSet.getLong("group_id"),
                            resultSet.getString("status"))
                    , id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Student[] getByGroup(long groupId) {
        return jdbcTemplate.query(
                        "SELECT id, lastname, firstname, middlename, status, group_id " +
                                "FROM student WHERE group_id = ?",
                        (resultSet, rowNum) -> new Student(
                                resultSet.getLong("id"),
                                resultSet.getString("lastname"),
                                resultSet.getString("firstname"),
                                resultSet.getString("middlename"),
                                resultSet.getLong("group_id"),
                                resultSet.getString("status"))
                        , groupId)
                .toArray(new Student[0]);
    }

    @Override
    public Student[] getAll() {
        return jdbcTemplate.query(
                        "SELECT id, lastname, firstname, middlename, status, group_id " +
                                "FROM student",
                        (resultSet, rowNum) -> new Student(
                                resultSet.getLong("id"),
                                resultSet.getString("lastname"),
                                resultSet.getString("firstname"),
                                resultSet.getString("middlename"),
                                resultSet.getLong("group_id"),
                                resultSet.getString("status")))
                .toArray(new Student[0]);
    }
}
