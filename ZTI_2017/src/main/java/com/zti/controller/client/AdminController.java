package com.zti.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zti.model.User;
import com.zti.service.UserService;
import com.zti.validator.EditUserValidator;

/**
 * Kontroler przeznaczony tylko dla użytkowników z rolą ROLE_ADMIN
 * 
 * @author PawełN
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	/**
	 * Serwis użytkowników
	 */
	@Autowired
	private UserService userService;
	/**
	 * Walidator modelu użytkownika
	 */
	@Autowired
	private EditUserValidator userValidator;

	/**
	 * Wyświetla widok użytkowników
	 * 
	 * @param model
	 *            Widok modelu
	 * @return Użytkownicy
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String showUsers(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "admin/users";
	}

	/**
	 * Wyświetla pojedynczego użytkownika w trybie edycji
	 * 
	 * @param id
	 *            Identyfikator użytkownika
	 * @param model
	 *            Widok modelu
	 * @return Użytkownik w trybie edycji
	 */
	@RequestMapping(value = "user/edit/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("userForm", user);
		return "admin/editUser";
	}

	/**
	 * Edycja pojedynczego użytkownika
	 * 
	 * @param userForm
	 *            Formularz użytkownika
	 * @param id
	 *            Identyfikator użytkownika
	 * @param bindingResult
	 *            Walidacja użytkownika
	 * @param model
	 *            Model widoku
	 * @return Edytuje użytkownika lub zwraca formularz z wykrytymi błędami
	 */
	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("userForm") User userForm, @PathVariable("id") Long id,
			BindingResult bindingResult, Model model) {

		User user = userService.findById(id);

		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "redirect:/admin/user/edit/" + id.toString();
		}

		user.setFirstname(userForm.getFirstname());
		user.setLastname(userForm.getLastname());
		user.setEmail(userForm.getEmail());
		user.setUsername(userForm.getUsername());

		userService.save(user);

		return "redirect:/admin/users";
	}

	/**
	 * Usuwanie użytkownika
	 * 
	 * @param id
	 *            Idetyfikator użytkownika
	 */
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable("id") Long id) {

		userService.deleteById(id);

	}

	/**
	 * Widok do dodawania pomiaru
	 * 
	 * @param model
	 *            Model widoku
	 * @return Dodawanie pomiaru
	 */
	@RequestMapping(value = "addMeasurement", method = RequestMethod.GET)
	public String addMeasurement(Model model) {
		return "rest/addMeasurement";
	}

	/**
	 * Widok do edytowania i usuwania pomiaru
	 * 
	 * @param model
	 *            Model widoku
	 * @return Edycja użytkownika
	 */
	@RequestMapping(value = "editMeasurement", method = RequestMethod.GET)
	public String editMeasurement(Model model) {
		return "rest/editMeasurement";
	}

}
