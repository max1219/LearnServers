package org.ogr.gor.www.old.validators.requests.lessons;

import org.ogr.gor.www.old.entities.requests.lessons.GetAttendanceRequest;
import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;
import org.ogr.gor.www.old.validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetAttendanceRequestValidator implements IRequestValidator<GetAttendanceRequest> {
    private final IIdValidator idValidator;

    public GetAttendanceRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }


    @Override
    public List<String> validate(GetAttendanceRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect lesson id");
        }

        return result;
    }
}
