package edu.rtu.lv.numbers;

import jakarta.persistence.*;

@Entity
@Table(name = "numbers")
public class NumberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "number")
    private Integer number;

    public Long getId() {
        return id;
    }

    public NumberEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getNumber() {
        return number;
    }

    public NumberEntity setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
