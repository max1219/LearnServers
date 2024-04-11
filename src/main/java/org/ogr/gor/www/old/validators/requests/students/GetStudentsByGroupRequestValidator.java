package org.ogr.gor.www.old.validators.requests.students;

import org.ogr.gor.www.old.entities.requests.students.GetStudentsByGroupRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsByGroupRequestValidator implements IRequestValidator<GetStudentsByGroupRequest> {
    private final IIdValidator idValidator;

    public GetStudentsByGroupRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentsByGroupRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
