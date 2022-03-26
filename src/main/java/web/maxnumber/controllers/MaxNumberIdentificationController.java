package web.maxnumber.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import web.maxnumber.services.MaxNumberIdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaxNumberIdentificationController {
    @Autowired
    private MaxNumberIdentificationService maxNumberIdentificationService;
    @GetMapping("/max-number")
    public ResponseEntity<Object> identifyMaxNumber(
            @RequestParam(name="firstNumber", required = true) int firstNumber,
            @RequestParam(name="secondNumber", required = true) int secondNumber,
            @RequestParam(name="thirdNumber", required = true) int thirdNumber
    ) {

        return new ResponseEntity<>(maxNumberIdentificationService.identifyMaxNumber(
                firstNumber,
                secondNumber,
                thirdNumber
        ), HttpStatus.OK);
    }
}