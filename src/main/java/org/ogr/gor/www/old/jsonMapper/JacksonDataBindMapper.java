package org.ogr.gor.www.old.jsonMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ogr.gor.www.old.exceptions.other_exceptions.JsonException;

public class JacksonDataBindMapper implements IJsonMapper {
    private final ObjectMapper mapper;

    public JacksonDataBindMapper() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public <T> T map(Class<T> class_, String json) throws JsonException {
        return null;
     //   try {
     //       return mapper.readValue(json, class_);
     //   } catch (JsonMappingException e) {
     //       throw new JsonException("Не удалось десериализовать строку", e);
     //   }
    }
}
