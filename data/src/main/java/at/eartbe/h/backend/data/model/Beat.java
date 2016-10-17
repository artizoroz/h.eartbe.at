package at.eartbe.h.backend.data.model;

import java.util.Date;

public class Beat {

	private Integer id;
	private String message;
	private Date beat_date;
	private Float latitude;
	private Float longitude;
	private User userFrom;
	private User userTo;
	
	
	/**
	 * 
	 */
	public Beat() {
	}
	/**
	 * @param id
	 * @param message
	 * @param beat_date
	 * @param latitude
	 * @param longitude
	 * @param idfrom
	 * @param idto
	 */
	public Beat(Integer id, String message, Date beat_date, Float latitude, Float longitude, User userFrom,
			User userTo) {
		this.id = id;
		this.message = message;
		this.beat_date = beat_date;
		this.latitude = latitude;
		this.longitude = longitude;
		this.userFrom = userFrom;
		this.userTo = userTo;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the beat_date
	 */
	public Date getBeat_date() {
		return beat_date;
	}
	/**
	 * @param beat_date the beat_date to set
	 */
	public void setBeat_date(Date beat_date) {
		this.beat_date = beat_date;
	}
	/**
	 * @return the latitude
	 */
	public Float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public Float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the userFrom
	 */
	public User getUserFrom() {
		return userFrom;
	}
	/**
	 * @param idfrom the userFrom to set
	 */
	public void setUserFrom(User userFrom) {
		this.userFrom = userFrom;
	}
	/**
	 * @return the userTo
	 */
	public User getUserTo() {
		return userTo;
	}
	/**
	 * @param idto the userTo to set
	 */
	public void setUserTo(User userTo) {
		this.userTo = userTo;
	}
	
	
}
