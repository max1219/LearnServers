package validators.requests;

import java.util.List;

public interface IRequestValidator<T> {
    List<String> validate(T obj);
}
