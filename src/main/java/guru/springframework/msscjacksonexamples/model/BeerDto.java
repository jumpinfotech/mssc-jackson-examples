package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @JsonProperty("beerId") // when converted to JSON instead of "id":"6dd... we get "beerId":"6dd... 
    // Overrides configured naming strategy. If using SNAKE_CASE? Don't expect beer_id you get beerId, other values stay SNAKE_CASE e.g. beer_style
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING) // BigDecimal was outputted as a number in JSON:- "price":12.99,
    // Now it's a String (good for handling world currencies) "price":"12.99",
    private BigDecimal price;

//    @JsonFormat>controls the output of JSON during serialization (DTO to JSON), maybe Spring or Jackson sets up a default date formatter
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING) // change the format of an outputted date
    private OffsetDateTime createdDate;

    private OffsetDateTime lastUpdatedDate;

    @JsonSerialize(using = LocalDateSerializer.class) // uses serializer > DTO to JSON
    @JsonDeserialize(using = LocalDateDeserializer.class) // deserialize > JSON to DTO
    private LocalDate myLocalDate; // LocalDate from Java 8
}
