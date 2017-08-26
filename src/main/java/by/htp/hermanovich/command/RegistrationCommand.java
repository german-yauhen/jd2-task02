package by.htp.hermanovich.command;

import java.util.Map;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.pojo.User;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class provides and describes actions/methods meant for processing with
 * user's registration data.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("/registration")
public class RegistrationCommand {
	private static final Logger logger = Logger.getLogger(RegistrationCommand.class);

	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	/**
	 * The method is used for populating command and form object
	 * arguments of annotated handler methods.
	 * @param dataBinder - special object for data binding from web request parameters
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	/**
	 * This method describes action to prepare a summary object of registration
	 * and return a name of view of registration form.
	 * @param model - an information which will be represented in the browser
	 * @return a name of view of registration page
	 */
	@RequestMapping("/register")
	public String redirectToRegistration(Model model) {
		model.addAttribute("registrData", new User());
		model.addAttribute("countryOptions", countryOptions);
		logger.info(Constants.SUCCESS);
		return "registration-page";
	}

	/**
	 * This method describes action to process user's registration data stored
	 * into the request object and implements a validation this stored data.
	 * @param registrData - a POJO corresponding with the model
	 * @param model - an information which will be represented in the browser
	 * @param bindingResult - an object holds the results of validation
	 * @return a name of view of main page (if the validation was successful) or 
	 */
	@RequestMapping(value = "/register/process-registration-form", method = RequestMethod.POST)
	public String processRegistrationForm(@Valid @ModelAttribute("registrData") User registrData,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			logger.info(Constants.FORM_FIELDS_ERROR);
			return "registration-page";
		}
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
		return "welcome-page";
	}
}