package org.ogr.gor.www.entities.database;

import java.util.Arrays;
import java.util.Objects;

public class Attendance {
    private final long[] visitedId;

    public Attendance(long[] visitedId) {
        this.visitedId = visitedId;
    }


    public long[] getVisitedId() {
        return visitedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Arrays.equals(visitedId, that.visitedId);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(visitedId);
    }
}
