package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.StudentGroup;
import org.ogr.gor.www.repositories.interfaces.IStudentGroupRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM student_group WHERE group_id = ?", id);
    }

    @Override
    public void edit(StudentGroup group) {
        jdbcTemplate.update(
                "UPDATE student_group SET group_name = ? WHERE group_id = ?", group.getName(), group.getId());
    }

    @Override
    public StudentGroup getById(long id) {
        return jdbcTemplate.queryForObject("SELECT group_id, group_name FROM student_group WHERE group_id = ?",
                (resultSet, rowNum) -> new StudentGroup(
                        resultSet.getLong("group_id"), resultSet.getString("group_name"))
                , id);
    }

    @Override
    public StudentGroup[] getAll() {
        return jdbcTemplate.query("SELECT group_id, group_name FROM student_group",
                        (resultSet, rowNum) -> new StudentGroup(
                                resultSet.getLong("group_id"), resultSet.getString("group_name")))
                .toArray(new StudentGroup[0]);
    }
}
