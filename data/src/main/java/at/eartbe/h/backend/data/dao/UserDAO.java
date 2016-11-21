/**
 * 
 */
package at.eartbe.h.backend.data.dao;

import java.util.List;

import at.eartbe.h.backend.data.model.User;

/**
 * @author Asier
 *
 */
public interface UserDAO extends GenericDAO<User> {

	public User selectByUsername(String name);

}
