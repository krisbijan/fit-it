package com.krisbijan.fitit.service.day;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krisbijan.fitit.model.Day;

@Repository
@Transactional
public interface DayRepository extends JpaRepository<Day, Integer> {

}
