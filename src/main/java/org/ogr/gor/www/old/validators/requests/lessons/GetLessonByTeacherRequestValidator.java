package org.ogr.gor.www.old.validators.requests.lessons;

import org.ogr.gor.www.old.entities.requests.lessons.GetLessonsByTeacherRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IDateValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByTeacherRequestValidator implements IRequestValidator<GetLessonsByTeacherRequest> {
    private final IDateValidator startDateValidator;
    private final IDateValidator endDateValidator;
    private final IIdValidator idValidator;

    public GetLessonByTeacherRequestValidator(IDateValidator startDateValidator, IDateValidator endDateValidator, IIdValidator idValidator) {
        this.startDateValidator = startDateValidator;
        this.endDateValidator = endDateValidator;
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetLessonsByTeacherRequest obj) {
        List<String> result = new ArrayList<>(3);

        if (!startDateValidator.validate(obj.getStartDate())) {
            result.add("Incorrect start date");
        }
        if (!endDateValidator.validate(obj.getEndDate())) {
            result.add("Incorrect end date");
        }
        if (!idValidator.validate(obj.getTeacherId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
