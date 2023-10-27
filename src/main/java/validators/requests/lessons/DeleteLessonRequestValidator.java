package validators.requests.lessons;

import entities.requests.lessons.DeleteLessonRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class DeleteLessonRequestValidator implements IRequestValidator<DeleteLessonRequest> {
    private final IIdValidator idValidator;

    public DeleteLessonRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;
    }

    @Override
    public List<String> validate(DeleteLessonRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())) {
            result.add("Incorrect lesson id");
        }

        return result;
    }
}
