package edu.rtu.lv.repository;

import edu.rtu.lv.numbers.NumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumbersRepository extends JpaRepository<NumberEntity, Long> {
}
