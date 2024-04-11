package org.ogr.gor.www.old.validators.primes.samples;

import org.ogr.gor.www.old.validators.primes.interfaces.INameValidator;

public class SampleNameValidator implements INameValidator {
    @Override
    public boolean validate(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return name.length() <= 64;
    }
}
