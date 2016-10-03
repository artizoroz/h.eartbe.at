/**
 * 
 */
package at.eartbe.h.backend.data;

import java.util.List;

import at.eartbe.h.backend.data.dao.UserDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateUserDAO;
import at.eartbe.h.backend.data.model.User;

/**
 * @author Asier
 *
 */
public class UserMain {

	/**
	 * @param args
	 */
	public static void showAll(UserDAO UserDAO) {
		// SELECT ALL DATA
		List<User> users = UserDAO.selectAll();
		System.out.println("--- USER ----- table contents	-----------");
		for (User user : users) {
			System.out.println("Id: " + user.getId());
			System.out.println(" - USERMANE: " + user.getUsername());
			System.out.println(" - PASSWORD: " + user.getPassword());
			System.out.println(" - EMAIL: " + user.getEmail());
		}
		System.out.println("Total Users: " + users.size());
	}
	public static void main(String[] args) {
		UserDAO userDAO = new HibernateUserDAO();
		showAll(userDAO);

		// INSERT NEW DATA
		User newUser = new User(12345923l,"Sanson","nosnas","san@son.com");
		userDAO.insert(newUser);
		System.out.println("Inserted id: " + newUser.getId());
		newUser = new User(5431314l,"Jonas","sanoj","jon@as.com");
		userDAO.insert(newUser);
		System.out.println("Inserted id: " + newUser.getId());		
		System.out.println("\nShow data after new insert");
		showAll(userDAO);
		
		// SELECT JUST ONE
		User oneUser = userDAO.selectById(Long.valueOf(1));
		System.out.println("\nShow the user with ID=1");
		System.out.println("--- USER ----- table contents	-----------");
		System.out.println("Selected Name: " + oneUser.getUsername());

		// UPDATE DATA
		newUser.setEmail("new@email.com");;
		userDAO.update(newUser);
		System.out.println("\nShow data after update");
		showAll(userDAO);

		// DELETE DATA
		userDAO.delete(newUser);
		System.out.println("\nShow data after deletion");
		showAll(userDAO);
	}

}
