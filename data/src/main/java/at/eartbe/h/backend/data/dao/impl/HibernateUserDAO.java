/**
 * 
 */
package at.eartbe.h.backend.data.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import at.eartbe.h.backend.data.HibernateSession;
import at.eartbe.h.backend.data.dao.UserDAO;
import at.eartbe.h.backend.data.model.User;

/**
 * @author Asier
 *
 */
public class HibernateUserDAO extends GenericDAOHibernate<User> implements UserDAO {

	public User selectByUsername(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
