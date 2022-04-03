package web.maxnumber.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.maxnumber.entities.CustomNumber;
import web.maxnumber.entities.Numbers;
import web.maxnumber.repositories.NumbersCache;

import java.util.Map;

@Service
public class NumberService {
    @Autowired
    private NumbersCache hashMap;

    public CustomNumber identifyMaxNumber(int firstNumber, int secondNumber, int thirdNumber) {
        Numbers numbers = new Numbers(firstNumber, secondNumber, thirdNumber);

        if (hashMap.hasKey(numbers)) {
            return hashMap.getValueByKey(numbers);
        }

        CustomNumber result = new CustomNumber(
                Math.max(
                    firstNumber,
                    Math.max(secondNumber, thirdNumber))
        );

        hashMap.create(numbers, result);

        return result;
    }

    public Map<Numbers, CustomNumber> getCache() {
        return hashMap.getNumbersCache();
    }
}