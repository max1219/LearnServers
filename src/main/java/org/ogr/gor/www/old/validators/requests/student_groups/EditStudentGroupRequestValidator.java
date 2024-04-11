package org.ogr.gor.www.old.validators.requests.student_groups;

import org.ogr.gor.www.old.entities.requests.student_groups.EditStudentGroupRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupRequestValidator implements IRequestValidator<EditStudentGroupRequest> {
    private final IIdValidator idValidator;
    private final INameValidator nameValidator;

    public EditStudentGroupRequestValidator(IIdValidator idValidator, INameValidator nameValidator) {
        this.idValidator = idValidator;
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(EditStudentGroupRequest obj) {
        List<String> result = new ArrayList<>(2);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect group id");
        }
        if (!nameValidator.validate(obj.getNewName())) {
            result.add("Incorrect name");
        }

        return result;
    }
}
