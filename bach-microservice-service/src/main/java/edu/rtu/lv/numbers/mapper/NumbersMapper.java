package edu.rtu.lv.numbers.mapper;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

@Component
public class NumbersMapper {

    public List<NumberEntity> fromDTO(NumbersResponse response) {
        if (response == null) {
            return Collections.emptyList();
        }

        return response.getNumbersList().stream()
                .map(NumberEntity::new)
                .toList();
    }

    public NumbersResponse toDTO(Iterable<NumberEntity> entityList, Integer currentAmount) {
        if (entityList == null) {
            return null;
        }

        List<Integer> numbersList = StreamSupport.stream(entityList.spliterator(), false)
                .map(NumberEntity::getNumber)
                .filter(Objects::nonNull)
                .toList();

        return NumbersResponse.builder()
                .amountOfNumbers(currentAmount)
                .numbersList(numbersList)
                .build();
    }
}
