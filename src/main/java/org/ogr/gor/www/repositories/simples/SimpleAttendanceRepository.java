package org.ogr.gor.www.repositories.simples;

import org.ogr.gor.www.entities.database.Attendance;
import org.ogr.gor.www.exceptions.repository_exceptions.NotFoundException;
import org.ogr.gor.www.repositories.interfaces.IAttendanceRepository;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class SimpleAttendanceRepository implements IAttendanceRepository {
    private final JdbcTemplate jdbcTemplate;

    public SimpleAttendanceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Attendance attendance) {
        long lessonId = attendance.getLessonId();
        long[] studentsId = attendance.getVisitedId();
        jdbcTemplate.batchUpdate(
                "INSERT INTO attendance (lesson_id, student_id) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setLong(1, lessonId);
                        preparedStatement.setLong(2, studentsId[i]);
                    }

                    @Override
                    public int getBatchSize() {
                        return studentsId.length;
                    }
                });
    }

    @Override
    public void delete(long id) throws NotFoundException {
        int affected = jdbcTemplate.update("DELETE FROM attendance WHERE lesson_id = ?", id);
        if (affected == 0) {
            throw new NotFoundException();
        }
    }

    @Override
    public Attendance getById(long id) {
        return new Attendance(id, jdbcTemplate.query(
                        "SELECT student_id " +
                                "FROM attendance WHERE lesson_id = ?",
                        (resultSet, i) -> resultSet.getLong("student_id"), id)
                .stream().mapToLong(value -> value).toArray());
    }
}
