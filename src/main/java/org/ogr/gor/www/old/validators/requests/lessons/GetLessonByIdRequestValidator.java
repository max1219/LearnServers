package org.ogr.gor.www.old.validators.requests.lessons;

import org.ogr.gor.www.old.entities.requests.lessons.GetLessonByIdRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetLessonByIdRequestValidator implements IRequestValidator<GetLessonByIdRequest> {
    private final IIdValidator idValidator;

    public GetLessonByIdRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;

    }

    @Override
    public List<String> validate(GetLessonByIdRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect lesson id");
        }

        return result;
    }
}
