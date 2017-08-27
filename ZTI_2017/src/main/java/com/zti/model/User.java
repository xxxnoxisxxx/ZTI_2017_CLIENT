package com.zti.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zti.serializer.UserSerializer;

/**
 * Model User reprezentujący obiekt w bazie danych
 * 
 * @author PawełN
 *
 */
@Entity
@JsonSerialize(using = UserSerializer.class)
@Table(name = "myuser")
public class User {
	/**
	 * Identyfikator obiektu
	 */
	private Long id;
	/**
	 * Imię
	 */
	private String firstname;
	/**
	 * Nazwisko
	 */
	private String lastname;
	/**
	 * Email
	 */
	private String email;
	/**
	 * Nazwa użytkownika
	 */
	private String username;
	/**
	 * Hasło
	 */
	private String password;
	/**
	 * Potwierdzenie hasła
	 */
	private String passwordConfirm;
	/**
	 * Role
	 */
	private Set<Role> roles;

	/**
	 * Konstruktor parametryzowany
	 * 
	 * @param id
	 *            Indetyfikator
	 * @param firstname
	 *            Imię
	 * @param lastname
	 *            Nazwisko
	 * @param email
	 *            Email
	 * @param username
	 *            Nazwa użytkownika
	 * @param password
	 *            Hasło
	 * @param passwordConfirm
	 *            Potwierdzenia hasła
	 * @param roles
	 *            Role
	 */
	public User(Long id, String firstname, String lastname, String email, String username, String password,
			String passwordConfirm, Set<Role> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.roles = roles;
	}

	/**
	 * Konstruktor domyślny
	 */
	public User() {
		super();
	}

	/**
	 * @return Indetyfikator ID
	 */
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "user_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	public Long getId() {
		return id;
	}

	/**
	 * Ustawia atrybut ID
	 * 
	 * @param id
	 *            Identyfikator obiektu
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Zwraca atrybut firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Ustawia atrybut firstname
	 * 
	 * @param firstname
	 *            Imię
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return Zwraca atrybut lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Ustawia atrybut lastname
	 * 
	 * @param lastname
	 *            Nazwisko
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return Zwraca atrybut email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Ustawia atrybut email
	 * 
	 * @param email
	 *            Email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Zwraca atrybut username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Ustawia atrybut username
	 * 
	 * @param username
	 *            Nazwa użytkownika
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return Zwraca atrybut password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Ustawia atrybut password
	 * 
	 * @param password
	 *            Hasło
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Zwraca atrybut passwordConfirm
	 */
	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	/**
	 * Ustawia atrybut passwordConfirm
	 * 
	 * @param passwordConfirm
	 *            Potwierdzenie hasła
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	/**
	 * @return Zwraca atrybut roles
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Ustawia atrybut roles
	 * 
	 * @param roles
	 *            Role
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}