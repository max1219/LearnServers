package org.ogr.gor.www.old.validators.requests.teachers;

import org.ogr.gor.www.old.entities.requests.teachers.EditTeacherRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditTeacherRequestValidator implements IRequestValidator<EditTeacherRequest> {
    private final IIdValidator idValidator;
    private final INameValidator lastNameValidator;
    private final INameValidator firstNameValidator;
    private final INameValidator middleNameValidator;

    public EditTeacherRequestValidator(IIdValidator idValidator, INameValidator lastNameValidator, INameValidator firstNameValidator, INameValidator middleNameValidator) {
        this.idValidator = idValidator;
        this.lastNameValidator = lastNameValidator;
        this.firstNameValidator = firstNameValidator;
        this.middleNameValidator = middleNameValidator;
    }

    @Override
    public List<String> validate(EditTeacherRequest obj) {
        List<String> result = new ArrayList<>(4);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }
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
