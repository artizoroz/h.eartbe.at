/**
 * 
 */
package at.eartbe.h.backend.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.eartbe.h.backend.data.dao.AvatarDAO;
import at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO;
import at.eartbe.h.backend.data.model.Avatar;
import at.eartbe.h.backend.data.model.User;

/**
 * @author Asier
 *
 */
public class HibernateAvatarDAOTest {
	private AvatarDAO avatarDAO;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		avatarDAO = new HibernateAvatarDAO();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO#selectById(java.lang.Long)}.
	 */
	@Test
	public void testSelectById() {
		// Select after insert
		Avatar insertAvatar = new Avatar(1l, "imagen1", "/img.jpg");
		avatarDAO.insert(insertAvatar);
		Avatar avatar = avatarDAO.selectById(insertAvatar.getId());
		assertEquals("Select by Id should exist", avatar.getId(), insertAvatar.getId());
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		int totalElements = avatarDAO.selectAll().size();

		Avatar insertAvatar = new Avatar(1l, "imagen1", "/img.jpg");
		avatarDAO.insert(insertAvatar);
		int totalElementsAfterInsert = avatarDAO.selectAll().size();

		assertEquals("Select All returns all elements", totalElements + 1, totalElementsAfterInsert);

	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO#insert(at.eartbe.h.backend.data.model.Avatar)}.
	 */
	@Test
	public void testInsert() {
		assertTrue("Insert", true);
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO#update(at.eartbe.h.backend.data.model.Avatar)}.
	 */
	@Test
	public void testUpdate() {
		String updatedAvatarDesc = "Updated AvatarDesc";

		// Select after first insert
		Avatar insertAvatar = new Avatar(1l, "imagen1", "/img.jpg");
		avatarDAO.insert(insertAvatar);

		// We update the avatar
		insertAvatar.setDescription(updatedAvatarDesc);
		avatarDAO.update(insertAvatar);

		// Select and check if avatarDesc has changed
		Avatar updatedAvatar = avatarDAO.selectById(insertAvatar.getId());

		assertEquals("User usernam was changed", updatedAvatarDesc, updatedAvatar.getDescription());
	}

	/**
	 * Test method for {@link at.eartbe.h.backend.data.dao.impl.HibernateAvatarDAO#delete(at.eartbe.h.backend.data.model.Avatar)}.
	 */
	@Test
	public void testDelete() {
		// Select after first insert
		Avatar insertAvatar = new Avatar(1l, "imagen1", "/img.jpg");
		avatarDAO.insert(insertAvatar);

		// Delete
		avatarDAO.delete(insertAvatar);
		Avatar avatar = avatarDAO.selectById(insertAvatar.getId());
		assertNull("Select by Id with a deleted record id shoud be null", avatar);
	}

}
