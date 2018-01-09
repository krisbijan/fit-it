package com.krisbijan.fitit.service.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.krisbijan.fitit.model.ExerciseCategory;

@Repository
@Transactional
public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategory, Integer>{
	
	
    @Query("SELECT p FROM ExerciseCategory p WHERE (p.userId) = (:userId)")
    public List<ExerciseCategory> findByUserId(@Param("userId") Integer userId);
    
    @Query("SELECT p FROM ExerciseCategory p WHERE (p.userId) = (:userId) AND (p.name) = (:name)")
    public List<ExerciseCategory> findByUserIdAndCategoryName(@Param("userId") Integer userId, @Param("name") String name);
}
