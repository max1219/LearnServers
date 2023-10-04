package validators.requests.student_groups;

import java.util.ArrayList;
import java.util.List;

import entities.requests.student_groups.AddStudentGroupRequest;
import validators.primes.interfaces.INameValidator;
import validators.requests.IRequestValidator;


public class AddStudentGroupRequestValidator implements IRequestValidator<AddStudentGroupRequest> {
    private final INameValidator nameValidator;

    public AddStudentGroupRequestValidator(INameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddStudentGroupRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!nameValidator.validate(obj.getName())) {
            result.add("Incorrect name");
        }

        return result;
    }
}
