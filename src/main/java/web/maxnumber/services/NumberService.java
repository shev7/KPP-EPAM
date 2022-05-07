package web.maxnumber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.maxnumber.dto.IdentifyNumbersResDTO;
import web.maxnumber.dto.NumberDTO;
import web.maxnumber.entities.CustomNumber;
import web.maxnumber.entities.Numbers;
import web.maxnumber.repositories.NumbersCache;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class NumberService {
    @Autowired
    private NumbersCache hashMap;

    @Autowired
    CounterService counterService;

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

        result.setCounter(counterService.increment());

        hashMap.create(numbers, result);

        return result;
    }

    public IntStream toIntStream(List<CustomNumber> numbers) {
        return numbers.stream().mapToInt((customNumber) -> customNumber.getNumber());
    }

    public IdentifyNumbersResDTO identifyListOfMaxNumbers(List<NumberDTO> data) {
        List<CustomNumber> resultList = new LinkedList<>();

        data.forEach((numbers) -> {
                resultList.add(
                        this.identifyMaxNumber(
                                numbers.firstNumber,
                                numbers.secondNumber,
                                numbers.thirdNumber
                        )
                );
        });

        IdentifyNumbersResDTO result = new IdentifyNumbersResDTO();

        result.maxNumber = toIntStream(resultList).max().getAsInt();
        result.minNumber = toIntStream(resultList).min().getAsInt();
        result.sum = toIntStream(resultList).sum();
        result.average = toIntStream(resultList).average().getAsDouble();
        result.list = resultList;

        return result;
    }

    public Map<Numbers, CustomNumber> getCache() {
        return hashMap.getNumbersCache();
    }
}