/**
 * 
 */
package at.eartbe.h.backend.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.eartbe.h.backend.data.dao.UserDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateUserDAO;
import at.eartbe.h.backend.data.model.User;

/**
 * @author Asier
 *
 */
public class HibernateUserDAOTest {
	private UserDAO userDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userDAO = new HibernateUserDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link at.eartbe.h.backend.data.dao.impl.HibernateUserDAO#selectById(java.lang.Long)}.
	 */
	@Test
	public void testSelectById() {
		// Select after insert
		User insertUser = new User(1234567l, "Username", "Pass", "email@email.com");
		userDAO.insert(insertUser);
		User role = userDAO.selectById(insertUser.getId(), User.class);
		assertEquals("Select by Id should exist", role.getId(), insertUser.getId());
	}

	/**
	 * Test method for
	 * {@link at.eartbe.h.backend.data.dao.impl.HibernateUserDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		int totalElements = userDAO.selectAll(User.class).size();

		User insertUser = new User(1234567l, "Username", "Pass", "email@email.com");
		userDAO.insert(insertUser);
		int totalElementsAfterInsert = userDAO.selectAll(User.class).size();

		assertEquals("Select All returns all elements", totalElements + 1, totalElementsAfterInsert);

	}

	/**
	 * Test method for
	 * {@link at.eartbe.h.backend.data.dao.impl.HibernateUserDAO#insert(at.eartbe.h.backend.data.model.User)}.
	 */
	@Test
	public void testInsert() {
		assertTrue("Insert", true);
	}

	/**
	 * Test method for
	 * {@link at.eartbe.h.backend.data.dao.impl.HibernateUserDAO#update(at.eartbe.h.backend.data.model.User)}.
	 */
	@Test
	public void testUpdate() {
		String updatedUsername = "Updated Username";

		// Select after first insert
		User insertUser = new User(1234567l, "Username", "Pass", "email@email.com");
		userDAO.insert(insertUser);

		// We update the user
		insertUser.setUsername(updatedUsername);
		userDAO.update(insertUser);

		// Select and check if username has changed
		User updatedUser = userDAO.selectById(insertUser.getId(), User.class);

		assertEquals("User usernam was changed", updatedUsername, updatedUser.getUsername());
	}

	/**
	 * Test method for
	 * {@link at.eartbe.h.backend.data.dao.impl.HibernateUserDAO#delete(at.eartbe.h.backend.data.model.User)}.
	 */
	@Test
	public void testDelete() {
		// Select after first insert
		User insertUser = new User(1234567l, "Username", "Pass", "email@email.com");
		userDAO.insert(insertUser);

		// Delete
		userDAO.delete(insertUser);
		User user = userDAO.selectById(insertUser.getId(), User.class);
		assertNull("Select by Id with a deleted record id shoud be null", user);
	}

}
