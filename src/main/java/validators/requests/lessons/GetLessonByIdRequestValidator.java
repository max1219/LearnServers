package validators.requests.lessons;

import java.util.ArrayList;
import java.util.List;

import entities.requests.lessons.GetLessonByIdRequest;
import validators.primes.interfaces.IIdValidator;
import validators.requests.IRequestValidator;

public class GetLessonByIdRequestValidator implements IRequestValidator<GetLessonByIdRequest> {
    private final IIdValidator idValidator;

    public GetLessonByIdRequestValidator(IIdValidator idValidator) {
        this.idValidator = idValidator;

    }

    @Override
    public List<String> validate(GetLessonByIdRequest obj) {
        List<String> result = new ArrayList<>(1);

        if (!idValidator.validate(obj.getId())){
            result.add("Incorrect lesson id");
        }

        return result;
    }
}
