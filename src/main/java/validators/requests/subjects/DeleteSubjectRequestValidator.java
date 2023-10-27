package validators.requests.subjects;

import entities.requests.subjects.DeleteSubjectRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteSubjectRequestValidator implements IRequestValidator<DeleteSubjectRequest> {
    private final IIdValidator idValidator;

    public DeleteSubjectRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteSubjectRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect id");
        }

        return result;
    }
}
