package edu.rtu.lv.numbers.service;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import edu.rtu.lv.numbers.mapper.NumbersMapper;
import edu.rtu.lv.repository.NumbersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NumbersService {
    private static final Random RANDOM = new Random();
    private static final Long AMOUNT = 10000L;

    private final NumbersRepository numbersRepository;
    private final NumbersMapper numbersMapper;

    public NumbersService(NumbersRepository numbersRepository,
                          NumbersMapper numbersMapper) {
        this.numbersRepository = numbersRepository;
        this.numbersMapper = numbersMapper;
    }

    public List<NumberEntity> getNumbers() {
        return (List<NumberEntity>) numbersRepository.findAll();
    }

    public NumbersResponse saveNumbers() {
        NumbersResponse numbersResponse = generateNumbers();
        List<NumberEntity> entityList = numbersMapper.fromDTO(numbersResponse);
        numbersRepository.saveAll(entityList);
        return numbersResponse;
    }

    public NumbersResponse generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < AMOUNT; i++) {
            numbers.add(RANDOM.nextInt());
        }

        return NumbersResponse.builder()
                .numbersList(numbers)
                .build();
    }
}
