package com.krisbijan.fitit.service.exercise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.krisbijan.fitit.model.Exercise;

@Repository
@Transactional
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

	List<Exercise> findByUserEmail(String userEmail);
}
