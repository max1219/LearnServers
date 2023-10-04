package validators.requests.subjects;

import entities.requests.student_groups.AddStudentGroupRequest;
import entities.requests.subjects.AddSubjectRequest;
import validators.primes.interfaces.INameValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;


public class AddSubjectRequestValidator implements IRequestValidator<AddSubjectRequest> {
    private final INameValidator nameValidator;

    public AddSubjectRequestValidator(INameValidator nameValidator) {
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(AddSubjectRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!nameValidator.validate(obj.getName())) {
            result.add("Incorrect name");
        }

        return result;
    }
}
