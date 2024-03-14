package edu.rtu.lv.resource;

import edu.rtu.lv.numbers.NumbersResponse;
import edu.rtu.lv.numbers.service.NumbersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NumbersResource {

    private static final Logger logger = LoggerFactory.getLogger(NumbersResource.class);

    private final NumbersService numbersService;

    public NumbersResource(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @GetMapping(value = "terminal")
    public ResponseEntity<NumbersResponse> generateNumbers() {
        logger.debug("Generating numbers and printing them into console");
        return ResponseEntity.ok(numbersService.generateNumbersTerminal());
    }

    @PostMapping(value = "data-base")
    public ResponseEntity<Void> generateNumbersDB() {
        logger.debug("Generating numbers and posting them into db");
        numbersService.generateNumbersDB();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
