package edu.rtu.lv.repository;

import edu.rtu.lv.numbers.NumberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends CrudRepository<NumberEntity, Integer> {
}
