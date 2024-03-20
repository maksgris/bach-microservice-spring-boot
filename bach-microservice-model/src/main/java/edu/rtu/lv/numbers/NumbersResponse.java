package edu.rtu.lv.numbers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

@JsonDeserialize(builder = NumbersResponse.Builder.class)
public class NumbersResponse {

    private final Integer amountOfNumbers;
    private final List<Integer> numbersList;

    public NumbersResponse(Builder builder) {
        this.amountOfNumbers = builder.amountOfNumbers;
        this.numbersList = builder.numbersList;
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumbersResponse that = (NumbersResponse) o;
        return Objects.equals(amountOfNumbers, that.amountOfNumbers)
                && Objects.equals(numbersList, that.numbersList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountOfNumbers, numbersList);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NumbersResponse.class.getSimpleName() + "[", "]")
                .add("amountOfNumbers=" + amountOfNumbers)
                .add("numbersList=" + numbersList)
                .toString();
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private List<Integer> numbersList;
        private Integer amountOfNumbers;

        private Builder() {}

        public Builder numbersList(List<Integer> numbersList) {
            this.numbersList = numbersList;
            return this;
        }

        public Builder amountOfNumbers(Integer amountOfNumbers) {
            this.amountOfNumbers = amountOfNumbers;
            return this;
        }

        public NumbersResponse build() {
            return new NumbersResponse(this);
        }
    }
}
