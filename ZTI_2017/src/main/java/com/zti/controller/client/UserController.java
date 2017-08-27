package com.zti.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zti.model.User;
import com.zti.service.SecurityService;
import com.zti.service.UserService;
import com.zti.validator.UserValidator;

/**
 * Kontroler przeznaczony do zarządzania użytkownikami
 * 
 * @author PawełN
 *
 */
@Controller
public class UserController {
	/**
	 * Serwis użytkowników
	 */
	@Autowired
	private UserService userService;

	/**
	 * Serwis bezpieczeństwa
	 */
	@Autowired
	private SecurityService securityService;

	/**
	 * Walidator użytkowników podczas rejestracji
	 */
	@Autowired
	private UserValidator userValidator;

	/**
	 * Widok służący do rejestrowania użytkowników
	 * 
	 * @param model
	 *            Widok modelu
	 * @return Strona rejestracji
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		if (userService.isAuthenticated())
			return "redirect:/home";
		model.addAttribute("userForm", new User());

		return "registration";
	}

	/**
	 * Rejestracja użytkowników
	 * 
	 * @param userForm
	 *            Formularz użytkownika do rejestracji
	 * @param bindingResult
	 *            Walidacja użytkownika
	 * @param model
	 *            Modelwidoku
	 * @return Dodaje użytkownika lub zwraca fomularz z błędami
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/home";
	}

	/**
	 * Widok logowania użykownika
	 * 
	 * @param model
	 *            Model widoku
	 * @return Strona logowania
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		if (userService.isAuthenticated())
			return "redirect:/home";
		return "login";
	}
}