package com.krisbijan.fitit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "appuser")
public class Appuser {

	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, message = "First name should have at least 2 characters")
	@NotNull
	private String first_name;

	@Size(min = 2, message = "Last name should have at least 2 characters")
	@NotNull
	private String last_name;

	@Past
	private Date DOB;

	@NotNull
	@JsonIgnore
	private String password;

	/*
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles;
	*/

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user_id")
	private Set<Day> days = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user_id")
	private Set<Workout> workouts = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user_id")
	private Set<Exercise> exercises = new HashSet<>();


}
