package org.ogr.gor.www.old.validators.requests.subjects;

import org.ogr.gor.www.old.entities.requests.subjects.GetSubjectByIdRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetSubjectByIdRequestValidator implements IRequestValidator<GetSubjectByIdRequest> {
    private final IIdValidator idValidator;

    public GetSubjectByIdRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetSubjectByIdRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
