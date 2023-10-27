package validators.requests.students;

import entities.requests.students.GetStudentByIdRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentByIdRequestValidator implements IRequestValidator<GetStudentByIdRequest> {
    private final IIdValidator idValidator;

    public GetStudentByIdRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentByIdRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
