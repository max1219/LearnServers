package org.ogr.gor.www.entities.database;

import java.util.Arrays;
import java.util.Objects;

public class Attendance {
    private final long lessonId;
    private final long[] visitedId;

    public Attendance(long lessonId, long[] visitedId) {
        this.lessonId = lessonId;
        this.visitedId = visitedId;
    }


    public long[] getVisitedId() {
        return visitedId;
    }

    public long getLessonId() {
        return lessonId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return lessonId == that.lessonId && Arrays.equals(visitedId, that.visitedId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lessonId);
        result = 31 * result + Arrays.hashCode(visitedId);
        return result;
    }
}
