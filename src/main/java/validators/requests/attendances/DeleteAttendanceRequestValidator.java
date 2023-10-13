package validators.requests.attendances;

import entities.requests.attendances.DeleteAttendanceRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteAttendanceRequestValidator implements IRequestValidator<DeleteAttendanceRequest> {
    private final IIdValidator idValidator;

    public DeleteAttendanceRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }


    @Override
    public List<String> validate(DeleteAttendanceRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
