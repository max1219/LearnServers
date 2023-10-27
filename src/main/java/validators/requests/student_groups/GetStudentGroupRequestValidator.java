package validators.requests.student_groups;

import entities.requests.student_groups.GetStudentGroupRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class GetStudentGroupRequestValidator implements IRequestValidator<GetStudentGroupRequest> {
    private final IIdValidator idValidator;

    public GetStudentGroupRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(GetStudentGroupRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect group id");
        }

        return result;
    }
}
