package edu.rtu.lv.numbers.mapper;

import edu.rtu.lv.numbers.NumberEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class NumbersMapper {

    public List<NumberEntity> fromDTO(NumbersResponse response) {
        if (response == null) {
            return Collections.emptyList();
        }

        return response.getNumbersList().stream()
                .map(number -> new NumberEntity().setNumber(number))
                .toList();
    }

    public NumbersResponse toDTO(List<NumberEntity> entityList) {
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }

        List<Integer> numbersList = entityList.stream()
                .map(NumberEntity::getNumber)
                .filter(Objects::nonNull)
                .toList();

        return NumbersResponse.builder()
                .id(1L)
                .numbersList(numbersList)
                .build();
    }
}
