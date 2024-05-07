package org.ogr.gor.www.validators;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class IdValidator2 implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Long.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        long id = (long) o;
        if (id < 10){
            errors.reject("Id cannot be less than 10");
        }
    }
}
