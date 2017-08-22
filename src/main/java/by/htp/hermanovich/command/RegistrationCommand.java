package by.htp.hermanovich.command;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.hermanovich.domain.RegistrationData;

/**
 * This class describes action to prepare a summary object of registration
 * and name of view of registration form
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("/registration")
public class RegistrationCommand {
	
	/**
	 * This method describes action to prepare a summary object of registration
	 * and return a name of view of registration form
	 * @param model - an information which will be represented in the browser
	 * @return a name of view of registration form
	 */
	@RequestMapping("/registration-page")
	public String redirectToRegistration(Model model) {
		RegistrationData registrData = new RegistrationData();
		model.addAttribute("registrData", registrData);
		return "registration-page";
	}
	
}