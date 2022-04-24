package web.maxnumber.controllers;

import web.maxnumber.entities.CustomNumber;
import web.maxnumber.entities.Numbers;
import web.maxnumber.services.NumberService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

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
}