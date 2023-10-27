package validators.requests.students;

import entities.requests.students.DeleteStudentRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteStudentRequestValidator implements IRequestValidator<DeleteStudentRequest> {
    private final IIdValidator idValidator;

    public DeleteStudentRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteStudentRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
