/**
 * 
 */
package at.eartbe.h.backend.data.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import at.eartbe.h.backend.data.HibernateSession;
import at.eartbe.h.backend.data.dao.AvatarDAO;
import at.eartbe.h.backend.data.model.Avatar;

/**
 * @author Asier
 *
 */
public class HibernateAvatarDAO implements AvatarDAO {

	/*
	 * selects one avatar by Id
	 * 
	 * @param id
	 * 
	 * @return Avatar
	 */
	public Avatar selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		Avatar avatar = (Avatar) session.get(Avatar.class, id);
		session.close();
		return avatar;
	}

	/*
	 * retrieves all avatar from db
	 * 
	 * @return List of avatars
	 */
	public List<Avatar> selectAll() {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Avatar> avatars = session.createCriteria(Avatar.class).list();
		session.close();
		return avatars;
	}

	/*
	 * inserts a new avatar in database retrieves generated id and sets to
	 * avatar instance
	 * 
	 * @param new avatar
	 */
	public void insert(Avatar avatar) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Long id = (Long) session.save(avatar);
		avatar.setId(id);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * updates avatar
	 * 
	 * @param avatar to update
	 */
	public void update(Avatar avatar) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(avatar);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * delete given avatar
	 * 
	 * @param avatar to delete
	 */
	public void delete(Avatar avatar) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(avatar);
		session.getTransaction().commit();
		session.close();
	}

}
