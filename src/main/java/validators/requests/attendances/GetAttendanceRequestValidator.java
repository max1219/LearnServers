package validators.requests.attendances;

import entities.requests.attendances.GetAttendanceRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

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
            result.add("Incorrect id");
        }

        return result;
    }
}
