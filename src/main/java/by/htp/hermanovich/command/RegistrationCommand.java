package by.htp.hermanovich.command;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.hermanovich.domain.RegistrationData;

/**
 * This class provides and describes actions/methods
 * meant for processing with user's registration data.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("/registration")
public class RegistrationCommand {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	/**
	 * This method describes action to prepare a summary object of registration
	 * and return a name of view of registration form.
	 * @param model - an information which will be represented in the browser
	 * @return a name of view of registration page
	 */
	@RequestMapping("/registration-page")
	public String redirectToRegistration(Model model) {
		System.out.println("redirectToRegistration(): " + "SUCCESS");
		RegistrationData registrData = new RegistrationData();
		model.addAttribute("registrData", registrData);
		model.addAttribute("countryOptions", countryOptions);
		return "registration-page";
	}
	
	/**
	 * This method describes action to process user's registration data
	 * stored into the request object.
	 * @param model - an information which will be represented in the browser
	 * @return a name of view of main page
	 */
	@RequestMapping("/registration-page/process-registration-form")
	public String processRegistrationForm(@ModelAttribute("registrData") RegistrationData registrData, Model model) {
		System.out.println("processRegistrationForm(): " + "SUCCESS");
		StringBuilder result = new StringBuilder();
		String delimeter = "::";
		result.append(registrData.getName());
		result.append(delimeter);
		result.append(registrData.getSurname());
		result.append(delimeter);
		result.append(registrData.getDocument());
		result.append(delimeter);
		result.append(registrData.getDateOfBirth());
		result.append(delimeter);
		result.append(registrData.getLogin());
		model.addAttribute("result-user-data", String.valueOf(result));
		System.out.println(String.valueOf(result));
		System.out.println(String.valueOf(model));
		return "main-welcome-page";
	}
	
}