package entities.database;

import java.util.Arrays;
import java.util.Objects;

public class Attendance {
    private final Long id;
    private final long[] visitedId;

    public Attendance(Long id, long[] visitedId) {
        this.id = id;
        this.visitedId = visitedId;
    }

    public Long getId() {
        return id;
    }

    public long[] getVisitedId() {
        return visitedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(id, that.id) && Arrays.equals(visitedId, that.visitedId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(visitedId);
        return result;
    }
}
