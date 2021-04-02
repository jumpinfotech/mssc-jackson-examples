package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by jt on 2019-06-03.
 */
public class LocalDateSerializer extends JsonSerializer<LocalDate> {

    @Override
    public void serialize(LocalDate value, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        // Jackson serializes this (outgoing: DTO to JSON)>bring in JsonGenerator + the value it's serializing>apply this date formatter. 
        // without LocalDateSerializer:- "myLocalDate":"2019-06-03",
        // with LocalDateSerializer:- "myLocalDate":"20190603",
        jsonGenerator.writeObject(value.format(DateTimeFormatter.BASIC_ISO_DATE));
        // Can do lots of other formatting here. 
    }
}
