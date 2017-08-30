package by.htp.hermanovich.command;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.hermanovich.constant.Constants;
import by.htp.hermanovich.pojo.User;
import by.htp.hermanovich.util.HibernateUtil;

/**
 * This class provides and describes actions/methods meant
 * for read all users from the corresponding database table
 * and represent the list into the browser's page.
 * @author Hermanovich Yauheni
 */
@Controller
@RequestMapping("/read-users-context")
public class ReadUsersCommand {
	
	private static final Logger logger = Logger.getLogger(ReadUsersCommand.class);
	
	/**
	 * This method describes actions/methods meant for read all users from the database table.
	 * @param model - information which will be represented in the browser
	 * @return a name of view of the context page contains the list of all registered users
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/read-users")
	public String redirectToAllUsers(Model model) {
		String resultPage = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			List<User> usersList = session.createQuery("from User").getResultList();
			model.addAttribute("usersList", usersList);
			resultPage = "all-users-page";
		} catch (Exception e) {
			logger.error(Constants.HIBERNATE_EXCEPTION + e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		logger.info(Constants.SUCCESS);
		return resultPage;
	}
}