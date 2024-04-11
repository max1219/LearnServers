package org.ogr.gor.www.old.validators.primes.samples;

import org.ogr.gor.www.old.validators.primes.interfaces.IDateValidator;

public class SampleDateValidator implements IDateValidator {
    @Override
    public boolean validate(String date) {
        if (date == null || date.isEmpty()) {
            return false;
        }
        return date.matches("^\\d\\d[.-:]\\d\\d[.-:]\\d{2,4}$");
    }
}
