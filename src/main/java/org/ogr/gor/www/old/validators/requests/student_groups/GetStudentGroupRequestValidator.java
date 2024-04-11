package org.ogr.gor.www.old.validators.requests.student_groups;

import org.ogr.gor.www.old.entities.requests.student_groups.GetStudentGroupRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupRequestValidator implements IRequestValidator<GetStudentGroupRequest> {
    private final IIdValidator idValidator;

    public GetStudentGroupRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentGroupRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
