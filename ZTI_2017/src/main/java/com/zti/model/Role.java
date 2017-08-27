package com.zti.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Model Rola reprezentujący obiekt w bazie danych
 * 
 * @author PawełN
 *
 */
@Entity
@Table(name = "role")
public class Role {

	/**
	 * Identyfikator obiektu
	 */
	private Long id;
	/**
	 * Nazwa roli
	 */
	private String name;
	/**
	 * Opis roli
	 */
	private String description;
	/**
	 * Użytkownicy
	 */
	private Set<User> users;

	/**
	 * @return Identyfikator ID
	 */
	@Id
	@SequenceGenerator(name = "SEQ_GEN", sequenceName = "role_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
	public Long getId() {
		return id;
	}

	/**
	 * Ustawia atrybut ID
	 * 
	 * @param id
	 *            Identyfikator roli
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Zwraca atrybut name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Ustawia atrybut name
	 * 
	 * @param name
	 *            Nazwa
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Zwraca atrybut description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Ustawia atrybut description
	 * 
	 * @param description
	 *            Opis roli
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Użytkownicy przypisani do danej roli
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	public Set<User> getUsers() {
		return users;
	}

	/**
	 * Ustawia atrybut users
	 * 
	 * @param users
	 *            Użytkownicy do danej roli
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return description;
	}

}