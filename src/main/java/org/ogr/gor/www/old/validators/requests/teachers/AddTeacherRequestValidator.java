package org.ogr.gor.www.old.validators.requests.teachers;

import org.ogr.gor.www.old.entities.requests.teachers.AddTeacherRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddTeacherRequestValidator implements IRequestValidator<AddTeacherRequest> {
    private final INameValidator lastNameValidator;
    private final INameValidator firstNameValidator;
    private final INameValidator middleNameValidator;

    public AddTeacherRequestValidator(INameValidator lastNameValidator, INameValidator firstNameValidator, INameValidator middleNameValidator) {
        this.lastNameValidator = lastNameValidator;
        this.firstNameValidator = firstNameValidator;
        this.middleNameValidator = middleNameValidator;
    }

    @Override
    public List<String> validate(AddTeacherRequest obj) {
        List<String> result = new ArrayList<>(3);

        if (!lastNameValidator.validate(obj.getLastName())) {
            result.add("Incorrect last name");
        }
        if (!firstNameValidator.validate(obj.getFirstName())) {
            result.add("Incorrect first name");
        }
        if (!middleNameValidator.validate(obj.getMiddleName())) {
            result.add("Incorrect middle name");
        }


        return result;
    }
}
