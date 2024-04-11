package org.ogr.gor.www.old.validators.requests.teachers;

import org.ogr.gor.www.old.entities.requests.teachers.DeleteTeacherRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteTeacherRequestValidator implements IRequestValidator<DeleteTeacherRequest> {
    private final IIdValidator idValidator;

    public DeleteTeacherRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteTeacherRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
