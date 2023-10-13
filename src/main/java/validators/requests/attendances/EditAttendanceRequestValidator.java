package validators.requests.attendances;

import entities.requests.attendances.EditAttendanceRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditAttendanceRequestValidator implements IRequestValidator<EditAttendanceRequest> {
    private final IIdValidator attendanceIdValidator;
    private final IIdValidator lessonIdValidator;
    private final IIdValidator visitedIdValidator;

    public EditAttendanceRequestValidator(IIdValidator attendanceIdValidator, IIdValidator lessonIdValidator, IIdValidator visitedIdValidator) {
        this.attendanceIdValidator = attendanceIdValidator;
        this.lessonIdValidator = lessonIdValidator;
        this.visitedIdValidator = visitedIdValidator;
    }

    @Override
    public List<String> validate(EditAttendanceRequest obj) {
        List<String> result = new ArrayList<>(3);

        if(!attendanceIdValidator.validate(obj.getId())){
            result.add("Incorrect attendance id");
        }
        if (!lessonIdValidator.validate(obj.getLessonId())) {
            result.add("Incorrect lesson id");
        }
        for (long id : obj.getVisitedId()) {
            if (!visitedIdValidator.validate(id)) {
                result.add("Incorrect one of visited id");
                break;
            }
        }

        return result;
    }
}
