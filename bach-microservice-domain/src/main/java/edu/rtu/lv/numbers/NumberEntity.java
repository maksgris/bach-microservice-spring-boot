package edu.rtu.lv.numbers;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
@Table(name = "numbers")
public class NumberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "number")
    private Integer number;

    public NumberEntity(Integer number) {
        this.number = number;
    }

    public NumberEntity() {
    }
}
