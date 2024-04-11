package org.ogr.gor.www.old.validators.requests.subjects;

import org.ogr.gor.www.old.entities.requests.subjects.AddSubjectRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;


public class AddSubjectRequestValidator implements IRequestValidator<AddSubjectRequest> {
    private final INameValidator nameValidator;

    public AddSubjectRequestValidator(INameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddSubjectRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!nameValidator.validate(obj.getName())) {
            result.add("Incorrect name");
        }

        return result;
    }
}
