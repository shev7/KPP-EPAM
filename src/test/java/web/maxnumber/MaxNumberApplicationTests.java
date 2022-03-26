package web.maxnumber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

import web.maxnumber.services.NumberService;
import web.maxnumber.entities.CustomNumber;

@SpringBootTest
class NumberServiceTests {

    @Autowired
    private NumberService numberService;

    @Test
    void testIdentifyMaxNumber()  {
        int firstNumber = 12;
        int secondNumber = 123;
        int thirdNumber = 42;

        CustomNumber expectedValue = new CustomNumber(secondNumber);

        CustomNumber returnedValue = numberService.identifyMaxNumber(
                firstNumber,
                secondNumber,
                thirdNumber
        );

        assertEquals(expectedValue.getNumber(), returnedValue.getNumber());
    }
}
