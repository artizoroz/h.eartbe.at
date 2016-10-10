package at.eartbe.h.backend.data.dao;

import java.util.List;

import at.eartbe.h.backend.data.model.Role;



/**
 * CustomerDAO interface
 * 
 * @author Eugenia Pérez Martínez
 *
 */
public interface RoleDAO {

	public Role selectById(Long id);

	public List<Role> selectAll();

	public void insert(Role role);

	public void update(Role role);

	public void delete(Role role);

}
