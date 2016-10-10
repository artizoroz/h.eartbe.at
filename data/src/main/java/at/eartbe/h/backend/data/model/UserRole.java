package at.eartbe.h.backend.data.model;

public class UserRole {

	private Long idUser;
	private Long idRole;
	private Long id;

	/**
	 * @param idUser
	 * @param idRole
	 */
	public UserRole(Long idUser, Long idRole, Long id) {
		this.idUser = idUser;
		this.idRole = idRole;
		this.id = id;
	}

	public UserRole() {

	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idUser
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser
	 *            the idUser to set
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the idRole
	 */
	public Long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole
	 *            the idRole to set
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

}
