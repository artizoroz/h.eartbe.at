/**
 * 
 */
package at.eartbe.h.backend.data.model;

/**
 * @author Asier
 *
 */
public class Avatar {
	private Long Id;
	private String description;
	private String image;
	private User user;
	/**
	 * 
	 */
	public Avatar() {
		super();
	}
	/**
	 * @param id
	 * @param description
	 * @param image
	 */
	public Avatar(Long id, String description, String image) {
		super();
		this.Id = id;
		this.description = description;
		this.image = image;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.Id = id;
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
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	

}
