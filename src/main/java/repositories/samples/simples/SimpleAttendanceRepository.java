package repositories.samples.simples;

import entities.database.Attendance;
import repositories.interfaces.IAttendanceRepository;

public class SimpleAttendanceRepository implements IAttendanceRepository {

    @Override
    public long add(Attendance attendance) {
        System.out.print("Add attendance");
        return 0;
    }

    @Override
    public void delete(long id) {
        System.out.print("Delete attendance");
    }

    @Override
    public Attendance getById(long id) {
        return new Attendance(0L, new long[]{0, 0, 0});
    }
}
