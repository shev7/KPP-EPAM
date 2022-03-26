package web.maxnumber.services;

import org.springframework.stereotype.Service;
import web.maxnumber.entities.CustomNumber;

@Service
public class NumberService {
    public CustomNumber identifyMaxNumber(int firstNumber, int secondNumber, int thirdNumber) {
        return new CustomNumber(
                Math.max(
                    firstNumber,
                    Math.max(secondNumber, thirdNumber))
        );
    }
}