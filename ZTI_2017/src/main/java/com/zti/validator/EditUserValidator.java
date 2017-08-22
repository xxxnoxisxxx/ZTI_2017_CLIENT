package com.zti.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zti.model.User;
import com.zti.service.UserService;

@Component
public class EditUserValidator implements Validator {
	@Autowired
	private UserService userService;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
		if (user.getFirstname().length() < 1 || user.getFirstname().length() > 32) {
			errors.rejectValue("firstname", "Size.userForm.firstname");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
		if (user.getLastname().length() < 1 || user.getLastname().length() > 32) {
			errors.rejectValue("lastname", "Size.userForm.lastname");
		}

		User userByEmail = userService.findByEmail(user.getEmail());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		if ( userByEmail != null && userByEmail.getId() != user.getId()) {
			errors.rejectValue("email", "Duplicate.userForm.email");
		}

		if (!(user.getEmail() != null && user.getEmail().isEmpty())) {
			Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "Incorrect.userForm.email");
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		User userByUsername = userService.findByUsername(user.getUsername());
		if ( userByUsername != null && userByUsername.getId() != user.getId()) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
	}
}