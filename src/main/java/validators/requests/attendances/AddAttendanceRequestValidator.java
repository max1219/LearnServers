package validators.requests.attendances;

import entities.requests.attendances.AddAttendanceRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddAttendanceRequestValidator implements IRequestValidator<AddAttendanceRequest> {
    private final IIdValidator lessonIdValidator;
    private final IIdValidator visitedIdValidator;

    public AddAttendanceRequestValidator(IIdValidator lessonIdValidator, IIdValidator visitedIdValidator) {
        this.lessonIdValidator = lessonIdValidator;
        this.visitedIdValidator = visitedIdValidator;
    }


    @Override
    public List<String> validate(AddAttendanceRequest obj) {
        List<String> result = new ArrayList<>(2);

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
