package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.Teacher;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.ITeacherRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SimpleTeacherRepository implements ITeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Teacher> rowMapper = (resultSet, i) -> new Teacher(
            resultSet.getLong("id"),
            resultSet.getString("lastname"),
            resultSet.getString("firstname"),
            resultSet.getString("middlename"));

    public SimpleTeacherRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(Teacher teacher) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(
                "INSERT INTO teacher (lastname, firstname, middlename) VALUES (?, ?, ?) " +
                        "RETURNING id", Long.class,
                teacher.getLastName(), teacher.getFirstName(), teacher.getMiddleName()));
    }

    @Override
    public void delete(long id) throws NotFoundException {
        int affected = jdbcTemplate.update("DELETE FROM teacher WHERE id = ?", id);
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public void edit(Teacher teacher) throws NotFoundException {
        int affected = jdbcTemplate.update(
                "UPDATE teacher SET " +
                        "lastname = ?, firstname = ?, middlename = ? " +
                        "WHERE id = ?",
                teacher.getLastName(), teacher.getFirstName(), teacher.getMiddleName(),
                teacher.getId());
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public Teacher getById(long id) throws NotFoundException {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT id, lastname, firstname, middlename " +
                            "FROM teacher WHERE id = ?",
                    rowMapper
                    , id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException();
        }
    }

    @Override
    public Teacher[] getAll() {
        return jdbcTemplate.query(
                        "SELECT id, lastname, firstname, middlename " +
                                "FROM teacher",
                        rowMapper)
                .toArray(new Teacher[0]);
    }

}
