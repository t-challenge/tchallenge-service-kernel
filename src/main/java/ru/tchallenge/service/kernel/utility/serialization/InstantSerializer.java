package ru.tchallenge.service.kernel.utility.serialization;

import java.io.IOException;
import java.time.Instant;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class InstantSerializer extends JsonSerializer<Instant> {

    @Override
    public void serialize(final Instant value,
                          final JsonGenerator generator,
                          final SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        generator.writeString(value.toString());
    }

    @Override
    public Class<Instant> handledType() {
        return Instant.class;
    }
}
