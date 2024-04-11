package org.ogr.gor.www.old.validators.primes.samples;

import org.ogr.gor.www.old.validators.primes.interfaces.IIdValidator;

public class SampleIdValidator implements IIdValidator {
    @Override
    public boolean validate(long id) {
        return id >= 0;
    }
}
