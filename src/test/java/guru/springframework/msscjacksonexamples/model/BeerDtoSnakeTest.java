package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by jt on 2019-06-02.
 */
@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {


//    Other teams may produce JSON following different conventions. 
//    Jackson handles that>with several naming strategies>handling different scenarios.

    @Test
    void testSnake() throws JsonProcessingException {
        BeerDto dto = getDto();

        String json = objectMapper.writeValueAsString(dto);

        System.out.println(json); 
        // now instead of e.g.
        // "beerStyle":"Ale", we have 
        // "beer_style":"Ale" 
    }
}
