package org.ogr.gor.www.old.validators.requests;

import java.util.List;

public interface IRequestValidator<T> {
    List<String> validate(T obj);
}
