package com.krisbijan.fitit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_entity")
public class UserEntity {

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
	
	@Size(min = 2, message = "Email should have at least 2 characters")
	@Email(message="Email not valid")
	private String email;

	@Past
	private Date DOB;

	@NotNull
	@JsonIgnore
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles;
//	
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "userEntity")
//	private Set<Workout> workouts = new HashSet<>();
//
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "userEntity")
//	private Set<Exercise> exercises = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

//	public Set<Workout> getWorkouts() {
//		return workouts;
//	}
//
//	public void setWorkouts(Set<Workout> workouts) {
//		this.workouts = workouts;
//	}
//
//	public Set<Exercise> getExercises() {
//		return exercises;
//	}
//
//	public void setExercises(Set<Exercise> exercises) {
//		this.exercises = exercises;
//	}

	

}
