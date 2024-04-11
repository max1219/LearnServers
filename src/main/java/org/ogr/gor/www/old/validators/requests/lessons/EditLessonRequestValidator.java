package org.ogr.gor.www.old.validators.requests.lessons;

import org.ogr.gor.www.old.entities.requests.lessons.EditLessonRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IClassNumberValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.IDateValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditLessonRequestValidator implements IRequestValidator<EditLessonRequest> {
    private final IIdValidator lessonIdValidator;
    private final IDateValidator dateValidator;
    private final IClassNumberValidator classNumberValidator;
    private final IIdValidator teacherIdValidator;
    private final IIdValidator groupIdValidator;

    public EditLessonRequestValidator(IIdValidator lessonIdValidator, IDateValidator dateValidator, IClassNumberValidator classNumberValidator, IIdValidator teacherIdValidator, IIdValidator groupIdValidator) {
        this.lessonIdValidator = lessonIdValidator;
        this.dateValidator = dateValidator;
        this.classNumberValidator = classNumberValidator;
        this.teacherIdValidator = teacherIdValidator;
        this.groupIdValidator = groupIdValidator;
    }

    @Override
    public List<String> validate(EditLessonRequest obj) {
        List<String> result = new ArrayList<>(5);

        if (!lessonIdValidator.validate(obj.getId())) {
            result.add("Incorrect lesson id");
        }
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
