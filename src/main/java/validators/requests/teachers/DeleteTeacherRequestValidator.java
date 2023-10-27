package validators.requests.teachers;

import entities.requests.teachers.DeleteTeacherRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

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
