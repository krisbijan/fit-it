package com.krisbijan.fitit.service.workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krisbijan.fitit.model.Workout;

@Repository
@Transactional
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
