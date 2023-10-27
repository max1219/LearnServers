package validators.primes.samples;

import validators.primes.interfaces.IStatusValidator;

public class SampleStatusValidator implements IStatusValidator {
    @Override
    public boolean validate(String status) {
        if (status == null || status.isEmpty()) {
            return false;
        }
        return status.equals("A") || status.equals("B") || status.equals("C");
    }
}
