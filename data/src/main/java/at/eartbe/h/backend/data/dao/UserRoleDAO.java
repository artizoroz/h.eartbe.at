/**
 * 
 */
package at.eartbe.h.backend.data.dao;

import java.util.List;

import at.eartbe.h.backend.data.model.UserRole;

/**
 * @author User
 *
 */
public interface UserRoleDAO {

	public UserRole selectById(Long id);

	public List<UserRole> selectAll();

	public void insert(UserRole customer);

	public void update(UserRole customer);

	public void delete(UserRole customer);

}
