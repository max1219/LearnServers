package validators.requests.lessons;

import java.util.ArrayList;
import java.util.List;

import entities.requests.lessons.GetLessonsByGroupRequest;
import validators.primes.interfaces.IDateValidator;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

public class GetLessonByGroupRequestValidator implements IRequestValidator<GetLessonsByGroupRequest> {
    private final IDateValidator startDateValidator;
    private final IDateValidator endDateValidator;
    private final IIdValidator idValidator;

    public GetLessonByGroupRequestValidator(IDateValidator startDateValidator, IDateValidator endDateValidator, IIdValidator idValidator) {
        this.startDateValidator = startDateValidator;
        this.endDateValidator = endDateValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetLessonsByGroupRequest obj) {
        List<String> result = new ArrayList<>(3);

        if (!startDateValidator.validate(obj.getStartDate())) {
            result.add("Incorrect start date");
        }
        if (!endDateValidator.validate(obj.getEndDate())) {
            result.add("Incorrect end date");
        }
        if (!idValidator.validate(obj.getGroupId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
