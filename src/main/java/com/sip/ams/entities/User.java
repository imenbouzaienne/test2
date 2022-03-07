package com.sip.ams.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long id;

	@Column(name = "first_Name")
	@NotEmpty(message = "Please provide your firstName")
	private String firstName;

	@Column(name = "last_Name")
	@NotEmpty(message = "Please provide your lastName")
	private String lastName;

	@Column(name = "email")
	@Email(message = "Please validate your Email")
	@NotEmpty(message = "Please provide your email")
	private String email;

	@Column(name = "active")
	private int active;

	public User(long id, String firstName, String lastName, String email, int active, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.password = password;
	}

	@Column(name = "password")
	@Length(min = 8, message = "*Your password must have at least 8 characters")
	@NotEmpty(message = "Please provide your password")
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role")
	@JoinColumn(name = "role_id", nullable = false)
    
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
