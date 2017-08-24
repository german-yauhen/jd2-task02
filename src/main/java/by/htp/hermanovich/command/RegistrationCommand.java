package by.htp.hermanovich.command;

import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.hermanovich.constants.Constants;
import by.htp.hermanovich.domain.RegistrationData;

/**
 * This class provides and describes actions/methods
 * meant for processing with user's registration data.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("/registration")
public class RegistrationCommand {
	private static final Logger logger = Logger.getLogger(RegistrationCommand.class);
	
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
		RegistrationData registrData = new RegistrationData();
		model.addAttribute("registrData", registrData);
		model.addAttribute("countryOptions", countryOptions);
		logger.info(Constants.SUCCESS);
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
		StringBuilder result = new StringBuilder();
		result.append(registrData.getName());
		result.append(Constants.DELIMETER);
		result.append(registrData.getSurname());
		result.append(Constants.DELIMETER);
		result.append(registrData.getDocument());
		result.append(Constants.DELIMETER);
		result.append(registrData.getSex());
		result.append(Constants.DELIMETER);
		result.append(registrData.getDateOfBirth());
		result.append(Constants.DELIMETER);
		result.append(registrData.getLogin());
		model.addAttribute("resultUserData", String.valueOf(result));
		logger.info(String.valueOf(result));
		logger.info(Constants.SUCCESS);
		return "main-welcome-page";
	}
	
}