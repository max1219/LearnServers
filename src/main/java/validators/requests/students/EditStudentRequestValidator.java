package validators.requests.students;

import entities.requests.students.EditStudentRequest;
import validators.primes.interfaces.IIdValidator;
import validators.primes.interfaces.INameValidator;
import validators.primes.interfaces.IStatusValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentRequestValidator implements IRequestValidator<EditStudentRequest> {
    private final IIdValidator idValidator;
    private final INameValidator lastNameValidator;
    private final INameValidator firstNameValidator;
    private final INameValidator middleNameValidator;
    private final IIdValidator groupIdValidator;
    private final IStatusValidator statusValidator;

    public EditStudentRequestValidator(IIdValidator idValidator, INameValidator lastNameValidator, INameValidator firstNameValidator, INameValidator middleNameValidator, IIdValidator groupIdValidator, IStatusValidator statusValidator) {
        this.idValidator = idValidator;
        this.lastNameValidator = lastNameValidator;
        this.firstNameValidator = firstNameValidator;
        this.middleNameValidator = middleNameValidator;
        this.groupIdValidator = groupIdValidator;
        this.statusValidator = statusValidator;
    }

    @Override
    public List<String> validate(EditStudentRequest obj) {
        List<String> result = new ArrayList<>(6);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }
        if (!lastNameValidator.validate(obj.getLastName())) {
            result.add("Incorrect last name");
        }
        if (!firstNameValidator.validate(obj.getFirstName())) {
            result.add("Incorrect first name");
        }
        if (!middleNameValidator.validate(obj.getMiddleName())) {
            result.add("Incorrect middle name");
        }
        if (!groupIdValidator.validate(obj.getGroupId())) {
            result.add("Incorrect group id");
        }
        if (!statusValidator.validate(obj.getStatus())) {
            result.add("Incorrect status");
        }

        return result;
    }
}
