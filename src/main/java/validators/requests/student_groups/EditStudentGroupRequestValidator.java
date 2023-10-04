package validators.requests.student_groups;

import entities.requests.student_groups.EditStudentGroupRequest;
import validators.primes.interfaces.IIdValidator;
import validators.primes.interfaces.INameValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class EditStudentGroupRequestValidator implements IRequestValidator<EditStudentGroupRequest> {
    private final IIdValidator idValidator;
    private final INameValidator nameValidator;

    public EditStudentGroupRequestValidator(IIdValidator idValidator, INameValidator nameValidator) {
        this.idValidator = idValidator;
        this.nameValidator = nameValidator;
    }

    @Override
    public List<String> validate(EditStudentGroupRequest obj) {
        List<String> result = new ArrayList<>(2);

        if (!idValidator.validate(obj.getId())){
            result.add("Incorrect group id");
        }
        if (!nameValidator.validate(obj.getNewName())){
            result.add("Incorrect name");
        }

        return result;
    }
}
