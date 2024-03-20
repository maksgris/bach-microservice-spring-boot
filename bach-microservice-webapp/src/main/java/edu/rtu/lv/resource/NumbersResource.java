package edu.rtu.lv.resource;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import edu.rtu.lv.numbers.service.NumbersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NumbersResource {

    private static final Logger logger = LoggerFactory.getLogger(NumbersResource.class);

    private final NumbersService numbersService;

    public NumbersResource(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @GetMapping(value = "/get-numbers")
    public ResponseEntity<NumbersResponse> getNumbers() {
        return ResponseEntity.ok(numbersService.getNumbers());
    }

    @PostMapping(value = "/save-numbers")
    public ResponseEntity<NumbersResponse> saveNumbers(@RequestParam Integer numbersAmount) {
        logger.debug("Generating numbers and saving them to db");
        return ResponseEntity.ok(numbersService.saveNumbers(numbersAmount));
    }

    @DeleteMapping(value = "delete-numbers")
    public ResponseEntity<Void> deleteNumbers() {
        logger.debug("Removing all numbers from db");
        numbersService.deleteNumbers();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
