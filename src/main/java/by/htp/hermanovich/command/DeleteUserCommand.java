package by.htp.hermanovich.command;

import by.htp.hermanovich.pojo.User;
import by.htp.hermanovich.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import by.htp.hermanovich.constant.Constants;
import java.util.List;

/**
 * This class describes and provides action/method meants for
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
	 * The method perfroms the following actions: gets user's id from the request, executes query to delete an user
	 * from database table, executes query to read a list of users from database table for update an information
	 * on the <i>all-users-page.jsp</i>
	 * @param userId - an user's unique identifier which will be deleted from the database table
	 * @param model - information which will be represented in the browser
	 * @return a name of view of the updated context of the application
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String redirectToDeleteUser(@RequestParam("userId") Integer userId, Model model) {
		String resultPage = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.createQuery("delete from User where id=" + userId).executeUpdate();
			List<User> usersList = session.createQuery("from User").getResultList();
			model.addAttribute("usersList", usersList);
			session.getTransaction().commit();
			logger.info(Constants.USER_HAS_BEEN_DELETED);
			resultPage = "redirect:/read-users-context/read-users";
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