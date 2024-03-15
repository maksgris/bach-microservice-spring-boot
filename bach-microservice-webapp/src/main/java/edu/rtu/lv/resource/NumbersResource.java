package edu.rtu.lv.resource;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import edu.rtu.lv.numbers.service.NumbersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class NumbersResource {

    private static final Logger logger = LoggerFactory.getLogger(NumbersResource.class);

    private final NumbersService numbersService;

    public NumbersResource(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @GetMapping(value = "/get-numbers")
    public ResponseEntity<List<NumberEntity>> getNumbers() {
        return ResponseEntity.ok(numbersService.getNumbers());
    }

    @PostMapping(value = "/save-numbers")
    public ResponseEntity<NumbersResponse> saveNumbers() {
        logger.debug("Generating numbers and saving them to db");
        return ResponseEntity.ok(numbersService.saveNumbers());
    }

    @PostMapping(value = "/print-numbers")
    public ResponseEntity<NumbersResponse> generateNumbers() {
        logger.debug("Generating numbers and printing them into console");
        return ResponseEntity.ok(numbersService.generateNumbers());
    }
}
