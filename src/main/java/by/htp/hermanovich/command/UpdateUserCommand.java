package by.htp.hermanovich.command;

import by.htp.hermanovich.pojo.User;
import by.htp.hermanovich.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.hermanovich.constant.Constants;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("*/update-context")
public class UpdateUserCommand {
	private static final Logger logger = Logger.getLogger(UpdateUserCommand.class);
	
	@RequestMapping(value = "/update-form", method = RequestMethod.GET)
	public String redirectToUpdateUser(@RequestParam("userId") Integer userId, Model model) {
		String resultPage = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			User userForUpdate = session.get(User.class, userId);
			session.getTransaction().commit();
			model.addAttribute("userForUpdate", userForUpdate);
			model.addAttribute("countries", RegistrationCommand.getCountriesFromDB());
			logger.info(Constants.SUCCESS);
			resultPage = "update-page";
		} catch (Exception e) {
			logger.error(Constants.HIBERNATE_EXCEPTION + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return resultPage;
	}

	@RequestMapping(value = "process-update-form", method = RequestMethod.POST)
	public String processUpdateForm(HttpServletRequest request) {
		String resultPage = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			User userForUpdate = session.get(User.class, Integer.parseInt(request.getParameter("userId")));
			userForUpdate.setName(request.getParameter("name"));
			userForUpdate.setSurname(request.getParameter("surname"));
			userForUpdate.setDocument(request.getParameter("document"));
			userForUpdate.setSex(request.getParameter("gender"));
			userForUpdate.setDateOfBirth(request.getParameter("dateOfBirth"));
			userForUpdate.setLogin(request.getParameter("login"));
			userForUpdate.setPassword(request.getParameter("password"));
			userForUpdate.setCountry(request.getParameter("country"));
			session.getTransaction().commit();
			logger.info(Constants.USER_DATA_HAVE_BEEN_UPDATED);
			resultPage = "all-users-page";
		} catch (Exception e) {
			logger.error(Constants.HIBERNATE_EXCEPTION + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return resultPage;
	}
}