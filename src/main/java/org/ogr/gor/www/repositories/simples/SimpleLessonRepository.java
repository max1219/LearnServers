package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.Lesson;
import org.ogr.gor.www.old.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.ILessonRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class SimpleLessonRepository implements ILessonRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Lesson> rowMapper = (resultSet, i) -> new Lesson(
            resultSet.getLong("id"),
            resultSet.getString("lesson_date"),
            resultSet.getInt("lesson_number"),
            resultSet.getLong("teacher_id"),
            resultSet.getLong("group_id"));

    public SimpleLessonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long add(Lesson lesson) {
        return Objects.requireNonNull(jdbcTemplate.queryForObject(
                "INSERT INTO lesson (lesson_date, lesson_number, teacher_id, group_id) VALUES (?, ?, ?, ?) " +
                        "RETURNING id", Long.class,
                lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId()));
    }

    @Override
    public void delete(long id) throws NotFoundException {
        int affected = jdbcTemplate.update("DELETE FROM lesson WHERE id = ?", id);
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public void edit(Lesson lesson) throws NotFoundException {
        int affected = jdbcTemplate.update(
                "UPDATE lesson SET " +
                        "lesson_date = ?, lesson_number = ?, teacher_id = ?, group_id = ? " +
                        "WHERE id = ?",
                lesson.getDate(), lesson.getNumber(), lesson.getTeacherId(), lesson.getGroupId(),
                lesson.getId());
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public void deleteByTeacherId(long id) {
        jdbcTemplate.update("DELETE FROM lesson WHERE teacher_id = ?", id);
    }

    @Override
    public void deleteByGroupId(long id) {
        jdbcTemplate.update("DELETE FROM lesson WHERE grouip_id = ?", id);
    }

    @Override
    public Lesson getById(long id) throws NotFoundException {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT id, lesson_date, lesson_number, teacher_id, group_id " +
                            "FROM lesson WHERE id = ?",
                    rowMapper
                    , id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException();
        }
    }

    @Override
    public Lesson[] getByTeacherId(String startDate, String endDate, long id) {
        return jdbcTemplate.query(
                "SELECT id, lesson_date, lesson_number, teacher_id, group_id " +
                        "FROM lesson WHERE teacher_id = ? AND lesson_date >= ? AND lesson_date <= ?",
                rowMapper
                , id, startDate, endDate).toArray(new Lesson[0]);
    }

    @Override
    public Lesson[] getByGroupId(String startDate, String endDate, long id) {
        return jdbcTemplate.query(
                "SELECT id, lesson_date, lesson_number, teacher_id, group_id " +
                        "FROM lesson WHERE group_id = ? AND lesson_date >= ? AND lesson_date <= ?",
                rowMapper
                , id, startDate, endDate).toArray(new Lesson[0]);
    }
}
