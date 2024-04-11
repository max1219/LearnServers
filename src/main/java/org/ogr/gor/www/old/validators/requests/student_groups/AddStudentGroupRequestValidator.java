package org.ogr.gor.www.old.validators.requests.student_groups;

import org.ogr.gor.www.old.entities.requests.student_groups.AddStudentGroupRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;


public class AddStudentGroupRequestValidator implements IRequestValidator<AddStudentGroupRequest> {
    private final INameValidator nameValidator;

    public AddStudentGroupRequestValidator(INameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddStudentGroupRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!nameValidator.validate(obj.getName())) {
            result.add("Incorrect name");
        }

        return result;
    }
}
