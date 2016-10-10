package at.eartbe.h.backend.data;

import java.util.List;

import at.eartbe.h.backend.data.dao.UserRoleDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO;
import at.eartbe.h.backend.data.model.UserRole;

public class UserRoleMain {

	/**
	 * App entry point.
	 * 
	 * @param customerDAO
	 */
	public static void showAll(UserRoleDAO userRoleDAO) {
		// SELECT ALL DATA
		List<UserRole> userRoles = userRoleDAO.selectAll();
		System.out.println("--- USERROLE ----- table contents	-----------");
		for (UserRole userRole : userRoles) {
			System.out.println("Id: " + userRole.getId());
			System.out.println(" - IdRole: " + userRole.getIdRole());
			System.out.println(" - IdUser: " + userRole.getIdUser());
		}
		System.out.println("Total userRoles: " + userRoles.size());
	}

	public static void main(String[] args) {
		UserRoleDAO userRoleDAO = new HibernateUserRoleDAO();
		showAll(userRoleDAO);

		// INSERT NEW DATA
		UserRole newUserRole = new UserRole(1L,2L,3L);
		userRoleDAO.insert(newUserRole);
		System.out.println("Inserted id: " + newUserRole.getId());
		newUserRole = new UserRole(2L,3L,4L);
		userRoleDAO.insert(newUserRole);
		System.out.println("Inserted id: " + newUserRole.getId());		
		System.out.println("\nShow data after new insert");
		showAll(userRoleDAO);
		
		// SELECT JUST ONE
		UserRole oneUserRole = userRoleDAO.selectById(Long.valueOf(1));
		System.out.println("\nShow the userRole with ID=1");
		System.out.println("--- USERROLE ----- table contents	-----------");
		System.out.println("Selected Name: " + oneUserRole.getIdRole());

		// UPDATE DATA
		newUserRole.setId(5L);
		userRoleDAO.update(newUserRole);
		System.out.println("\nShow data after update");
		showAll(userRoleDAO);

		// DELETE DATA
		userRoleDAO.delete(newUserRole);
		System.out.println("\nShow data after deletion");
		showAll(userRoleDAO);
	}
}
