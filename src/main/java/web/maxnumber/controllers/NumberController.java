package web.maxnumber.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

import web.maxnumber.dto.IdentifyNumbersResDTO;
import web.maxnumber.dto.NumberDTO;
import web.maxnumber.entities.CustomNumber;
import web.maxnumber.entities.Numbers;
import web.maxnumber.services.NumberService;

@RestController
@Validated
public class NumberController {
    private static final Logger logger = LogManager.getLogger(NumberController.class);

    @Autowired
    private NumberService numberService;

    @GetMapping("/max-number")
    public ResponseEntity<CustomNumber> identifyMaxNumber(
            @RequestParam(name="firstNumber", required = true) int firstNumber,
            @RequestParam(name="secondNumber", required = true) int secondNumber,
            @RequestParam(name="thirdNumber", required = true) int thirdNumber
    ) {

        logger.info("\nGET /max-number\n");

        return ResponseEntity.ok(
                numberService.identifyMaxNumber(
                    firstNumber,
                    secondNumber,
                    thirdNumber
                )
        );
    }

    @GetMapping("/cache")
    public Map<Numbers, CustomNumber> getCache() {
        logger.info("GET /cache");

        return numberService.getCache();
    }

    @PostMapping("/max-number/list")
    public ResponseEntity<IdentifyNumbersResDTO> calculateListOfMaxNumbers(
            @Valid @RequestBody List<NumberDTO> numbersList
    ) {
        logger.info("POST /max-number/list");

        IdentifyNumbersResDTO result = this.numberService.identifyListOfMaxNumbers(numbersList);

        return ResponseEntity.ok(result);
    }
}