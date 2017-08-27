package com.zti.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zti.model.Role;
import com.zti.model.User;
import com.zti.repository.RoleRepository;
import com.zti.repository.UserRepository;

/**
 * Implementacja serwisu dla klasy UserService
 * 
 * @author PawełN
 *
 */
@Service
public class UserServiceImpl implements UserService {
	/**
	 * Repozytorium klasu User
	 */
	@Autowired
	private UserRepository userRepository;
	/**
	 * Repozytorium klasy Role
	 */
	@Autowired
	private RoleRepository roleRepository;
	/**
	 * Password encoder
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#save(com.zti.model.User)
	 */
	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		userRepository.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#findByUsername(java.lang.String)
	 */
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#findAll()
	 */
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#isAuthenticated()
	 */
	@Override
	public boolean isAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return (auth instanceof AnonymousAuthenticationToken) ? false : true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#findById(java.lang.Long)
	 */
	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.UserService#deleteById(java.lang.Long)
	 */
	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);

	}
}