/**
 * 
 */
package at.eartbe.h.backend.data.model;

import java.util.HashSet;
import java.util.Set;



/**
 * @author egoitz
 *
 */
public class Role {
	public Long id;
	public String name;
	public String description;
	private Set<User> users = new HashSet<User>();
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 */
	public Role(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Role(){
		
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the users
	 */
	public Set<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
