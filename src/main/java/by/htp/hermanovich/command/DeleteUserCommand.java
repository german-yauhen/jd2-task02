package by.htp.hermanovich.command;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.hermanovich.constant.Constants;

@Controller
@RequestMapping("*/delete-context")
public class DeleteUserCommand {
	private static final Logger logger = Logger.getLogger(DeleteUserCommand.class);
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String redirectToDeleteUser(@RequestParam("userId") Integer userId, Model model) {
		String resultPage = null;
		// TODO ACTIONS
		resultPage = "delete-page";
		logger.info(Constants.SUCCESS);
		return resultPage;
	}
}