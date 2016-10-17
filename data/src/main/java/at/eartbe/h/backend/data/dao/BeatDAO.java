/**
 * 
 */
package at.eartbe.h.backend.data.dao;

import java.util.List;

import at.eartbe.h.backend.data.model.Beat;

/**
 * @author User
 *
 */
public interface BeatDAO {

	public Beat selectById(Long id);

	public List<Beat> selectAll();

	public void insert(Beat beat);

	public void update(Beat beat);

	public void delete(Beat beat);
}
