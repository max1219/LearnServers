package org.ogr.gor.www.old.validators.requests.subjects;

import org.ogr.gor.www.old.entities.requests.subjects.EditSubjectRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditSubjectRequestValidator implements IRequestValidator<EditSubjectRequest> {
    private final IIdValidator idValidator;
    private final INameValidator nameValidator;

    public EditSubjectRequestValidator(IIdValidator idValidator, INameValidator nameValidator) {
        this.idValidator = idValidator;
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(EditSubjectRequest obj) {
        List<String> result = new ArrayList<>(2);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect group id");
        }
        if (!nameValidator.validate(obj.getName())) {
            result.add("Incorrect name");
        }

        return result;
    }
}
