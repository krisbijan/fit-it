package com.krisbijan.fitit.service.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krisbijan.fitit.model.Exercise;
import com.krisbijan.fitit.model.ExerciseCategory;

@Repository
@Transactional
public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, Integer>{

	List<ExerciseCategory> findByUserEmail(String userEmail);

	
}
