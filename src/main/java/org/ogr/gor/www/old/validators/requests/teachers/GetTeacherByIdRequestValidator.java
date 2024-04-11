package org.ogr.gor.www.old.validators.requests.teachers;

import org.ogr.gor.www.old.entities.requests.teachers.GetTeacherByIdRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetTeacherByIdRequestValidator implements IRequestValidator<GetTeacherByIdRequest> {
    private final IIdValidator idValidator;

    public GetTeacherByIdRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetTeacherByIdRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
