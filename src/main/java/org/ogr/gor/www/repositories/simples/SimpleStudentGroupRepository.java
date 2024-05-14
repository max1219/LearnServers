package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.StudentGroup;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.IStudentGroupRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;


@Component
public class SimpleStudentGroupRepository implements IStudentGroupRepository {
    private final JdbcTemplate jdbcTemplate;

    public SimpleStudentGroupRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public long add(StudentGroup group) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(
                "INSERT INTO student_group (group_name) VALUES (?) RETURNING group_id", Long.class, group.getName()));
    }

    @Override
    public void delete(long id) throws NotFoundException {
        int affected = jdbcTemplate.update("DELETE FROM student_group WHERE group_id = ?", id);
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public void edit(StudentGroup group) throws NotFoundException {
        int affected = jdbcTemplate.update(
                "UPDATE student_group SET group_name = ? WHERE group_id = ?", group.getName(), group.getId());
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public StudentGroup getById(long id) throws NotFoundException {
        StudentGroup result;
        try {
            result = jdbcTemplate.queryForObject("SELECT group_id, group_name FROM student_group WHERE group_id = ?",
                    (resultSet, rowNum) -> new StudentGroup(
                            resultSet.getLong("group_id"), resultSet.getString("group_name"))
                    , id);
        }
        catch (EmptyResultDataAccessException e){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public StudentGroup[] getAll() {
        return jdbcTemplate.query("SELECT group_id, group_name FROM student_group",
                        (resultSet, rowNum) -> new StudentGroup(
                                resultSet.getLong("group_id"), resultSet.getString("group_name")))
                .toArray(new StudentGroup[0]);
    }
}
