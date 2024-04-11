package org.ogr.gor.www.old.validators.requests.students;

import org.ogr.gor.www.old.entities.requests.students.GetStudentByIdRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdRequestValidator implements IRequestValidator<GetStudentByIdRequest> {
    private final IIdValidator idValidator;

    public GetStudentByIdRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentByIdRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
