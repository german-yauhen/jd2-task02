package by.htp.hermanovich.command;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.hermanovich.domain.RegistrationData;

@Controller
@RequestMapping("/registration")
public class RegistrationCommand {
	
	/**
	 * This method describes actions to prepare a summary object of registration.
	 * 
	 * @param model
	 * @return a name of view of registration form
	 */
	@RequestMapping("/registrationPage")
	public String redirectToRegistration(Model model) {
		RegistrationData registrData = new RegistrationData();
		model.addAttribute("registrData", registrData);
		return "registrationPage";
	}
	
}