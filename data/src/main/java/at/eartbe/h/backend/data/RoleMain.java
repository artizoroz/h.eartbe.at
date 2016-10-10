/**
 * 
 */
package at.eartbe.h.backend.data;

import java.util.List;

import at.eartbe.h.backend.data.dao.RoleDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateRoleDAO;
import at.eartbe.h.backend.data.model.Role;



/**
 * @author egoitz
 *
 */
public class RoleMain {
	/**
	 * App entry point.
	 * 
	 * @param roleDAO
	 */
	public static void showAll(RoleDAO roleDAO) {
		// SELECT ALL DATA
		List<Role> roles = roleDAO.selectAll();
		System.out.println("--- ROLE ----- table contents	-----------");
		for (Role role : roles) {
			System.out.println("Id: " + role.getId());
			System.out.println(" - Name: " + role.getName());
			System.out.println(" - Description: " + role.getDescription());
		}
		System.out.println("Total Roles: " + roles.size());
	}

	public static void main(String[] args) {
		RoleDAO roleDAO =  new HibernateRoleDAO();
		showAll(roleDAO);

		// INSERT NEW DATA
		Role newRole = new Role(1L,"Good", "The best");
		roleDAO.insert(newRole);
		System.out.println("Inserted id: " + newRole.getId());
		newRole = new Role(2L, "Bad",
				"Fuck all");
		roleDAO.insert(newRole);
		System.out.println("Inserted id: " + newRole.getId());		
		System.out.println("\nShow data after new insert");
		showAll(roleDAO);
		
		// SELECT JUST ONE
		Role oneRole = roleDAO.selectById(Long.valueOf(1));
		System.out.println("\nShow the role with ID=1");
		System.out.println("--- ROLE ----- table contents	-----------");
		System.out.println("Selected Name: " + oneRole.getName());

		// UPDATE DATA
		newRole.setDescription("Happy, So happy for be alive");
		roleDAO.update(newRole);
		System.out.println("\nShow data after update");
		showAll(roleDAO);

		// DELETE DATA
		roleDAO.delete(newRole);
		System.out.println("\nShow data after deletion");
		showAll(roleDAO);
	}
}
