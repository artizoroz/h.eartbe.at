/**
 * 
 */
package at.eartbe.h.backend.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import at.eartbe.h.backend.data.HibernateSession;
import at.eartbe.h.backend.data.dao.UserRoleDAO;
import at.eartbe.h.backend.data.model.UserRole;

/**
 * @author User
 *
 */
public class HibernateUserRoleDAO implements UserRoleDAO {

	/*
	 * selects one userRole by Id
	 * 
	 * @param id
	 * 
	 * @return UserRole
	 */
	public UserRole selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		UserRole userRoles = (UserRole) session.get(UserRole.class, id);
		session.close();
		return userRoles;
	}

	/*
	 * retrieves all userRoles from db
	 * 
	 * @return List of userRoles
	 */
	public List<UserRole> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<UserRole> userRoles = session.createCriteria(UserRole.class).list();
		session.close();
		return userRoles;
	}

	/*
	 * inserts a new userRole in database retrieves generated id and sets to
	 * userRole instance
	 * 
	 * @param new userRole
	 */
	public void insert(UserRole userRole) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(userRole);
		userRole.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates userRole
	 * 
	 * @param userRole to update
	 */
	public void update(UserRole userRole) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(userRole);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given userRole
	 * 
	 * @param userRole to delete
	 */
	public void delete(UserRole userRole) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(userRole);
		session.getTransaction().commit();
		session.close();
	}
}
