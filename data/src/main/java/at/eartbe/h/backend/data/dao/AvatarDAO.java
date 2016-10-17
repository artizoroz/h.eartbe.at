/**
 * 
 */
package at.eartbe.h.backend.data.dao;

import java.util.List;

import at.eartbe.h.backend.data.model.Avatar;
import at.eartbe.h.backend.data.model.User;

/**
 * @author Asier
 *
 */
public interface AvatarDAO {

	public Avatar selectById(Long id);

	public List<Avatar> selectAll();

	public void insert(Avatar avatar);

	public void update(Avatar avatar);

	public void delete(Avatar avatar);

}
