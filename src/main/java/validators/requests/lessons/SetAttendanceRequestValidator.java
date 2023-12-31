package validators.requests.lessons;

import entities.requests.lessons.SetAttendanceRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class SetAttendanceRequestValidator implements IRequestValidator<SetAttendanceRequest> {
    private final IIdValidator idValidator;
    private final IIdValidator visitedIdValidator;

    public SetAttendanceRequestValidator(IIdValidator idValidator, IIdValidator visitedIdValidator) {
        this.idValidator = idValidator;
        this.visitedIdValidator = visitedIdValidator;
    }

    @Override
    public List<String> validate(SetAttendanceRequest obj) {
        List<String> result = new ArrayList<>(2);

        if (!idValidator.validate(obj.getLessonId())) {
            result.add("Incorrect lesson id");
        }
        for (long id : obj.getVisitedId()) {
            if (!visitedIdValidator.validate(id)) {
                result.add("Incorrect one or more of visited id");
                break;
            }
        }

        return result;
    }
}
