package org.ogr.gor.www.old.validators.requests.students;

import org.ogr.gor.www.old.entities.requests.students.AddStudentRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.IStatusValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class AddStudentRequestValidator implements IRequestValidator<AddStudentRequest> {
    private final INameValidator lastNameValidator;
    private final INameValidator firstNameValidator;
    private final INameValidator middleNameValidator;
    private final IIdValidator groupIdValidator;
    private final IStatusValidator statusValidator;

    public AddStudentRequestValidator(INameValidator lastNameValidator, INameValidator firstNameValidator, INameValidator middleNameValidator, IIdValidator groupIdValidator, IStatusValidator statusValidator) {
        this.lastNameValidator = lastNameValidator;
        this.firstNameValidator = firstNameValidator;
        this.middleNameValidator = middleNameValidator;
        this.groupIdValidator = groupIdValidator;
        this.statusValidator = statusValidator;
    }

    @Override
    public List<String> validate(AddStudentRequest obj) {
        List<String> result = new ArrayList<>(5);

        if (!lastNameValidator.validate(obj.getLastName())) {
            result.add("Incorrect last name");
        }
        if (!firstNameValidator.validate(obj.getFirstName())) {
            result.add("Incorrect first name");
        }
        if (!middleNameValidator.validate(obj.getMiddleName())) {
            result.add("Incorrect middle name");
        }
        if (!groupIdValidator.validate(obj.getGroupId())) {
            result.add("Incorrect group id");
        }
        if (!statusValidator.validate(obj.getStatus())) {
            result.add("Incorrect status");
        }

        return result;
    }
}
