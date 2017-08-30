package by.htp.hermanovich.command;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.hermanovich.constant.Constants;

/**
 * This class describes and provides actions/methods meant for
 * delete user from the database table.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("*/delete-context")
public class DeleteUserCommand {
	
	private static final Logger logger = Logger.getLogger(DeleteUserCommand.class);
	
	/**
	 * This method describes actions to delete the user from the database table.
	 * Redirect to the updated context of the application which contains updated list of users.
	 * The method uses transaction support.
	 * @param userId - an user's unique identifier which will be deleted from the database table
	 * @param model - information which will be represented in the browser
	 * @return a name of view of the updated context of the application
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String redirectToDeleteUser(@RequestParam("userId") Integer userId, Model model) {
		String resultPage = null;
		// TODO ACTIONS
		resultPage = "delete-page";
		logger.info(Constants.SUCCESS);
		return resultPage;
	}
}