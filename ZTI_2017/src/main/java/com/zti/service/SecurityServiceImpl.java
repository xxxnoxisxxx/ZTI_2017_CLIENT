package com.zti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Implemenentacja serwisu klasy SecurityService
 * 
 * @author PawełN
 *
 */
@Service
public class SecurityServiceImpl implements SecurityService {
	/**
	 * Menadżer autentykacji
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Serwis użytkowników (Spring Security)
	 */
	@Autowired
	private UserDetailsService userDetailsService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.SecurityService#findLoggedInUsername()
	 */
	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetails instanceof UserDetails) {
			return ((UserDetails) userDetails).getUsername();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zti.service.SecurityService#autologin(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void autologin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}
}