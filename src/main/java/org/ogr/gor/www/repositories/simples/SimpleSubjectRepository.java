package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.Subject;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.ISubjectRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SimpleSubjectRepository implements ISubjectRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Subject> rowMapper = (resultSet, i) -> new Subject(
            resultSet.getLong("id"),
            resultSet.getString("subject_name"));

    public SimpleSubjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(Subject subject) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(
                "INSERT INTO subject (subject_name) VALUES (?) " +
                        "RETURNING id", Long.class,
                subject.getName()));
    }

    @Override
    public void delete(long id) throws NotFoundException {
        int affected = jdbcTemplate.update("DELETE FROM subject WHERE id = ?", id);
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public void edit(Subject subject) throws NotFoundException {
        int affected = jdbcTemplate.update(
                "UPDATE subject SET subject_name = ? WHERE id = ?", subject.getName(), subject.getId());
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public Subject getById(long id) throws NotFoundException {
        try {
            return jdbcTemplate.queryForObject("SELECT id, subject_name FROM subject WHERE id = ?",
                   rowMapper,
                    id);
        }
        catch (EmptyResultDataAccessException e){
            throw new NotFoundException();
        }
    }

    @Override
    public Subject[] getAll() {
        return jdbcTemplate.query(
                        "SELECT id, subject_name " +
                                "FROM subject",
                        rowMapper)
                .toArray(new Subject[0]);    }
}
