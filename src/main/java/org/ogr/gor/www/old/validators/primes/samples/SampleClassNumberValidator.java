package org.ogr.gor.www.old.validators.primes.samples;

import org.ogr.gor.www.old.validators.primes.interfaces.IClassNumberValidator;

public class SampleClassNumberValidator implements IClassNumberValidator {
    @Override
    public boolean validate(int number) {
        return number > 0 && number < 11;
    }
}
