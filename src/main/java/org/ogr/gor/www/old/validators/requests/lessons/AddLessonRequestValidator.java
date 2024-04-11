package org.ogr.gor.www.old.validators.requests.lessons;

import org.ogr.gor.www.old.entities.requests.lessons.AddLessonRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IClassNumberValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.IDateValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;


public class AddLessonRequestValidator implements IRequestValidator<AddLessonRequest> {
    private final IDateValidator dateValidator;
    private final IClassNumberValidator classNumberValidator;
    private final IIdValidator teacherIdValidator;
    private final IIdValidator groupIdValidator;

    public AddLessonRequestValidator(IDateValidator dateValidator, IClassNumberValidator classNumberValidator, IIdValidator teacherIdValidator, IIdValidator groupIdValidator) {
        this.dateValidator = dateValidator;
        this.classNumberValidator = classNumberValidator;
        this.teacherIdValidator = teacherIdValidator;
        this.groupIdValidator = groupIdValidator;
    }

    @Override
    public List<String> validate(AddLessonRequest obj) {
        List<String> result = new ArrayList<>(4);

        if (!dateValidator.validate(obj.getDate())) {
            result.add("Incorrect date");
        }
        if (!classNumberValidator.validate(obj.getNumber())) {
            result.add("Incorrect class number");
        }
        if (!teacherIdValidator.validate(obj.getTeacherId())) {
            result.add("Incorrect teacher id");
        }
        if (!groupIdValidator.validate(obj.getGroupId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
