package edu.rtu.lv.numbers.service;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import edu.rtu.lv.numbers.mapper.NumbersMapper;
import edu.rtu.lv.repository.NumbersRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NumbersService {
    private static final Random RANDOM = new Random();
    private static final Long AMOUNT = 100L;

    private final NumbersRepository numbersRepository;
    private final NumbersMapper numbersMapper;

    public NumbersService(@Validated NumbersRepository numbersRepository,
                          NumbersMapper numbersMapper) {
        this.numbersRepository = numbersRepository;
        this.numbersMapper = numbersMapper;
    }

    public NumbersResponse generateNumbersTerminal() {

        NumbersResponse numbersResponse = generateNumbers();
        System.out.println(numbersResponse);

        return numbersResponse;
    }

    public void generateNumbersDB() {
        NumbersResponse numbersResponse = generateNumbers();
        List<NumberEntity> entityList = numbersMapper.fromDTO(numbersResponse);

        numbersRepository.saveAll(entityList);
    }

    private NumbersResponse generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < AMOUNT; i++) {
            numbers.add(RANDOM.nextInt());
        }

        return NumbersResponse.builder()
                .numbersList(numbers)
                .build();
    }
}
