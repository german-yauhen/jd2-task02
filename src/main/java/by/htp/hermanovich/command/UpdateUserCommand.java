package by.htp.hermanovich.command;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.hermanovich.constant.Constants;

@Controller
@RequestMapping("*/update-context")
public class UpdateUserCommand {
	private static final Logger logger = Logger.getLogger(UpdateUserCommand.class);
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String redirectToUpdateUser(@RequestParam("userId") Integer userId, Model model) {
		String resultPage = null;
		// TODO ACTOINS
		resultPage = "update-page";
		logger.info(Constants.SUCCESS);
		return resultPage;
	}
}