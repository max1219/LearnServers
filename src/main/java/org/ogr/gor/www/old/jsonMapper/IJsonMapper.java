package org.ogr.gor.www.old.jsonMapper;

import org.ogr.gor.www.old.exceptions.other_exceptions.JsonException;

public interface IJsonMapper {
    <T> T map(Class<T> class_, String json) throws JsonException;
}
