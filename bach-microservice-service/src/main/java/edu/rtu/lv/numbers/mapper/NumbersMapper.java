package edu.rtu.lv.numbers.mapper;

import edu.rtu.lv.numbers.NumbersEntity;
import edu.rtu.lv.numbers.NumbersResponse;
import org.springframework.stereotype.Component;

@Component
public class NumbersMapper {

    public NumbersEntity fromDTO(NumbersResponse response) {
        if (response == null) {
            return null;
        }

        return new NumbersEntity()
                .setId(response.getId())
                .setNumbersList(response.getNumbersList());
    }

    public NumbersResponse toDTO(NumbersEntity entity) {
        if (entity == null) {
            return null;
        }

        return NumbersResponse.builder()
                .id(entity.getId())
                .numbersList(entity.getNumbersList())
                .build();
    }
}
