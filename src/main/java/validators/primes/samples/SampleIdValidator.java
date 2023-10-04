package validators.primes.samples;

import validators.primes.interfaces.IIdValidator;

public class SampleIdValidator implements IIdValidator {
    @Override
    public boolean validate(long id) {
        return id > 0;
    }
}
