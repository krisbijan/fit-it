package com.krisbijan.fitit.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@Entity
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Size(min = 1, message = "Name should have at least 1 characters")
	@Column
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private Appuser appuser;

	//0-reps exercise, 1-time exercise
	@Column
	private Boolean reps_or_time;

	@Column
	private Boolean template;
	
	@Column
	private Integer reps;
	
	@Column
	private Integer sets;

}
