package jsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.other_exceptions.JsonException;

public class JacksonDataBindMapper implements IJsonMapper {
    private final ObjectMapper mapper;

    public JacksonDataBindMapper() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public <T> T map(Class<T> class_, String json) throws JsonException {
        try {
            return mapper.readValue(json, class_);
        } catch (JsonProcessingException e) {
            throw new JsonException("Не удалось десериализовать строку", e);
        }
    }
}
