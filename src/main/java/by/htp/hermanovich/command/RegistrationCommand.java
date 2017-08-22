package by.htp.hermanovich.command;

import javax.servlet.http.HttpServletRequest;

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
		return "registration-page";
	}
	
	/**
	 * This method describes action to process user's registration data
	 * stored into the request object.
	 * @param model - an information which will be represented in the browser
	 * @return a name of view of main page
	 */
	@RequestMapping("/process-registration-form")
	public String processRegistrationForm(@ModelAttribute("registrData") RegistrationData registrData, HttpServletRequest request, Model model) {
		registrData.setName(request.getParameter("name"));
		registrData.setSurname(request.getParameter("surname"));
		registrData.setDocument(request.getParameter("document"));
		registrData.setDateOfBirth(request.getParameter("dateOfBirth"));
		registrData.setLogin(request.getParameter("login"));
		registrData.setPassword(request.getParameter("password"));
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
		model.addAttribute("result-user-data", result.toString());
		return "main-page";
	}
	
}