/**
 * 
 */
package at.eartbe.h.backend.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.eartbe.h.backend.data.dao.UserRoleDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO;
import at.eartbe.h.backend.data.model.UserRole;

/**
 * @author User
 *
 */
public class HibernateUserRoleDAOTest {
	private UserRoleDAO userRoleDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userRoleDAO = new HibernateUserRoleDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO#selectById(java.lang.Long)}.
	 */
	@Test
	public void testSelectById() {
		UserRole insertUser = new UserRole(1l,1l,1l);
		userRoleDAO.insert(insertUser);
		UserRole role = userRoleDAO.selectById(insertUser.getId());
		assertEquals("Select by Id should exist", role.getId(), insertUser.getId());
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		int totalElements = userRoleDAO.selectAll().size();

		UserRole insertUser = new UserRole(1l,1l,1l);
		userRoleDAO.insert(insertUser);
		int totalElementsAfterInsert = userRoleDAO.selectAll().size();

		assertEquals("Select All returns all elements", totalElements + 1, totalElementsAfterInsert);
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO#insert(at.eartbe.h.backend.data.model.UserRole)}.
	 */
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO#update(at.eartbe.h.backend.data.model.UserRole)}.
	 */
	@Test
	public void testUpdate() {
		long updatedIdUser = 2l;

		// Select after first insert
		UserRole insertUserRole = new UserRole(1l,1l,1l);
		userRoleDAO.insert(insertUserRole);

		// We update the user
		insertUserRole.setIdUser(updatedIdUser);
		userRoleDAO.update(insertUserRole);

		// Select and check if username has changed
		UserRole updatedUserRole = userRoleDAO.selectById(insertUserRole.getId());

		assertEquals("",updatedIdUser, (long) updatedUserRole.getIdUser());
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateUserRoleDAO#delete(at.eartbe.h.backend.data.model.UserRole)}.
	 */
	@Test
	public void testDelete() {
		UserRole insertUserRole = new UserRole(1l,1l,1l);
		userRoleDAO.insert(insertUserRole);

		// Delete
		userRoleDAO.delete(insertUserRole);
		UserRole userRole = userRoleDAO.selectById(insertUserRole.getId());
		assertNull("Select by Id with a deleted record id shoud be null", userRole);
	}

}
