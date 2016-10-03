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
public interface UserDAO {

	public User selectById(Long id);

	public List<User> selectAll();

	public void insert(User user);

	public void update(User user);

	public void delete(User user);

}
