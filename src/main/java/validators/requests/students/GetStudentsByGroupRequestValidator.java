package validators.requests.students;

import entities.requests.students.GetStudentsByGroupRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentsByGroupRequestValidator implements IRequestValidator<GetStudentsByGroupRequest> {
    private final IIdValidator idValidator;

    public GetStudentsByGroupRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentsByGroupRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
