package by.htp.hermanovich.command;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.hermanovich.constants.Constants;

/**
 * This class describes action to redirect to the index.jsp page automatically.
 * @author Hermanovich Yauheni
 */
@Controller
public class IndexPageCommand {
	private static final Logger logger = Logger.getLogger(IndexPageCommand.class);
	/**
	 * The method describes action to redirect to the index.jsp page.
	 * @param model - an information which will be represented in the browser 
	 * @return a redirect command represented in the string value
	 */
	@RequestMapping("/")
	public String redirectToIndexPage(Model model) {
		logger.info(Constants.SUCCESS);
		return "redirect:registration/registration-page";
	}
}