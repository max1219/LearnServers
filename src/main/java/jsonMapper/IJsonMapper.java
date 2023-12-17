package jsonMapper;

import exceptions.other_exceptions.JsonException;

public interface IJsonMapper {
    <T> T map(Class<T> class_, String json) throws JsonException;
}
