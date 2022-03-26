package web.maxnumber.services;

import org.springframework.stereotype.Service;
import web.maxnumber.entities.MaxNumber;

@Service
public class MaxNumberIdentificationService {
    public MaxNumber identifyMaxNumber(int firstNumber, int secondNumber, int thirdNumber) {
        MaxNumber maxNumberObj = new MaxNumber();

        maxNumberObj.setMaxNumber(
                Math.max(
                        firstNumber,
                        Math.max(secondNumber, thirdNumber)
                )
        );

        return maxNumberObj;
    }
}