package by.htp.hermanovich.command;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.pojo.Login;
import by.htp.hermanovich.pojo.User;
import by.htp.hermanovich.util.HibernateUtil;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * This class describes and provides actions/methods meant for an user
 * authentication in the application.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("/login-context")
public class LoginCommand {

	private static final Logger logger = Logger.getLogger(LoginCommand.class);

	/**
	 * This method describes action to prepare a summary object of
	 * authentication and return a name of view of authentication form. Redirect
	 * to the page with an authentication form.
	 * @param model - information which will be represented in the browser
	 * @return a name of view of login/authentication page
	 */
	@RequestMapping("/login-form")
	public String redirectToLogin(Model model) {
		model.addAttribute("loginData", new Login());
		logger.info(Constants.SUCCESS);
		return "login-page";
	}

	/**
	 * This method describes actions to process an authentication data from the
	 * form stored into the request object and check if the user with the data
	 * exists in the database table. This method invoke the checkLogin(login, password) method
	 * @param loginData - an object of Login.class with the information which will be processed
	 * @param model - information which will be represented in the browser
	 * @return a name of view of page corresponding with the account of the user
	 */
	@RequestMapping(value = "/process-login-form", method = RequestMethod.POST)
	public String processLoginData(@ModelAttribute("loginData") Login loginData, Model model) {
		String resultPage = null;
		if (checkLogin(loginData.getLogin(), loginData.getPassword())) {
			model.addAttribute("userLogin", loginData.getLogin());
			resultPage = "account-page";
		} else {
			model.addAttribute("error", Constants.INVALID_DETAILS);
			resultPage = "login-page";
		}
		logger.info(Constants.SUCCESS);
		return resultPage;
	}

	/**
	 * The method describes action to logout from the account. The method uses RedirectAttributes to store
	 * parameters using redirect action. After the redirect, flash attributes are automatically added to the model
	 * of the controller. The flash attributes, which are used in the method, are passed via the session
	 * and are destroyed immediately after being used.
	 * @param redirectAttributes - attributes for a redirect scenario
	 * @return a name of view of page corresponding with the login page of the application
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutProcess(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("logoutMessage", Constants.LOGOUT_SUCCESS);
		logger.info(Constants.SUCCESS);
		return "redirect:login-form";
	}

	/**
	 * This method describes actions to check the entered user's login and
	 * password according to the row in the corresponding database table.
	 * The method uses transaction support.
	 * @param login - an entered user's login
	 * @param password - an entered user's password
	 * @return a boolean value of expression "is user exist?" true or false
	 */
	private boolean checkLogin(String login, String password) {
		boolean isExist = false;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			Query query = session.createQuery("from User where login=? and password=?");
			query.setParameter(0, login);
			query.setParameter(1, password);
			List<User> resultFromQuery = query.getResultList();
			session.getTransaction().commit();
			if (resultFromQuery != null && resultFromQuery.size() > 0) {
				logger.info(Constants.USER_FOUND);
				isExist = true;
			} else {
				logger.info(Constants.USER_WAS_NOT_FOUND);
			}
		} catch (Exception e) {
			logger.error(Constants.HIBERNATE_EXCEPTION + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isExist;
	}
}