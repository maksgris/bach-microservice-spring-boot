package edu.rtu.lv.numbers.service;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import edu.rtu.lv.numbers.mapper.NumbersMapper;
import edu.rtu.lv.repository.NumbersRepository;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.StreamSupport;

@Service
public class NumbersService {
    private static final Random RANDOM = new Random();

    private final NumbersRepository numbersRepository;
    private final NumbersMapper numbersMapper;

    public NumbersService(NumbersRepository numbersRepository,
                          NumbersMapper numbersMapper) {
        this.numbersRepository = numbersRepository;
        this.numbersMapper = numbersMapper;
    }

    public NumbersResponse getNumbers() {
        return numbersMapper.toDTO(numbersRepository.findAll(), getCurrentAmount());
    }

    public NumbersResponse saveNumbers(Integer numbersAmount) {
        NumbersResponse numbersResponse = generateNumbers(numbersAmount);
        List<NumberEntity> entityList = numbersMapper.fromDTO(numbersResponse);
        numbersRepository.saveAll(entityList);
        return getNumbers();
    }

    public void deleteNumbers() {
        numbersRepository.deleteAll();
    }

    private NumbersResponse generateNumbers(Integer numbersAmount) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersAmount; i++) {
            numbers.add(RANDOM.nextInt());
        }

        return NumbersResponse.builder()
                .amountOfNumbers(getCurrentAmount() + numbersAmount)
                .numbersList(numbers)
                .build();
    }

    private Integer getCurrentAmount() {
        return IterableUtils.size(numbersRepository.findAll());
    }
}
