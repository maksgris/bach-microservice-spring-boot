package edu.rtu.lv.numbers;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "numbers")
public class NumbersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ElementCollection
    @Column(name = "numbers")
    private List<Integer> numbersList;

    public Long getId() {
        return id;
    }

    public NumbersEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public NumbersEntity setNumbersList(List<Integer> numbersList) {
        this.numbersList = numbersList;
        return this;
    }
}
