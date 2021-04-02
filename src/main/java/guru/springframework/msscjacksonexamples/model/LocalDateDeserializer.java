package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by jt on 2019-06-03.
 */
public class  LocalDateDeserializer extends StdDeserializer<LocalDate> { // LocalDate generic needed 

    public LocalDateDeserializer() { // values this deserializer handles
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return LocalDate.parse(p.readValueAs(String.class), DateTimeFormatter.BASIC_ISO_DATE); 
        // JSON value read as String to create LocalDate object, a timezone is expected in the JSON e.g. 
        // input="createdDate":"2019-06-03T21:01:53-0400",
        // output returned=myLocalDate=2019-06-03
    }
}
