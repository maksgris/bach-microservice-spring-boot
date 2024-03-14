package edu.rtu.lv.numbers.service;

import edu.rtu.lv.numbers.NumbersResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NumbersService {
    private static final Random RANDOM = new Random();
    private static final Long AMOUNT = 100L;

    public NumbersResponse generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < AMOUNT; i++) {
            numbers.add(RANDOM.nextInt());
        }

        NumbersResponse numbersResponse = NumbersResponse.builder()
                .numbersList(numbers)
                .build();
        System.out.println(numbersResponse);
        return numbersResponse;
    }

    // TODO: WIP
    public NumbersResponse generateNumbersDB() {
        return null;
    }
}
