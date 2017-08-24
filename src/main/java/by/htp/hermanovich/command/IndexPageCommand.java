package by.htp.hermanovich.command;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class describes action to redirect to the index.jsp page automatically.
 * @author Hermanovich Yauheni
 */
@Controller

public class IndexPageCommand {
	
	/**
	 * The method describes action to redirect to the index.jsp page.
	 * @param model - an information which will be represented in the browser 
	 * @return a redirect command represented in the string value
	 */
	@RequestMapping("/")
	public String redirectToIndexPage(Model model) {
		System.out.println("redirectToIndexPage(): " + "SUCCESS");
		return "redirect:registration/registration-page";
	}
}