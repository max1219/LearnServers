package org.ogr.gor.www.old.validators.primes.samples;

import org.ogr.gor.www.old.validators.primes.interfaces.IStatusValidator;

public class SampleStatusValidator implements IStatusValidator {
    @Override
    public boolean validate(String status) {
        if (status == null || status.isEmpty()) {
            return false;
        }
        return status.equals("A") || status.equals("B") || status.equals("C");
    }
}
